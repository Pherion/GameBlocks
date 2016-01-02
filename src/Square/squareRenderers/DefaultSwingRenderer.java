package Square.squareRenderers;

import io.ResourceRetriever;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Square renderer for swing.
 *
 * Created by fraca_000 on 1/2/2016.
 */
public class DefaultSwingRenderer extends SquareRenderer {
    /**
     * The filename of the resource item to be used in this square.
     */
    private String filename;

    /**
     * The image this renderer will write.
     */
    private BufferedImage image;

    /**
     * Creates a new swing renderer.
     *
     * @param filename The filename of the resource that will be written by this renderer.
     */
    public DefaultSwingRenderer(String filename) {
        this.filename = filename;
    }

    @Override
    public boolean render(Graphics graphics, int xLocation, int yLocation, int width, int height) {
        // check if the image has been populated
        if(image == null) {
            // create the image key
            String imageKey = filename.concat(":").concat(Integer.toString(width)).concat(",").concat(Integer.toString(height));

            // check if the image repository already has the image opened.
            if (imageRepository.contains(imageKey)) {
                // pull the image from the repository
                image = imageRepository.get(imageKey);
            } else {
                // extract the image from resources
                try {
                    image = getImageFromResources(filename);
                } catch (IOException e) {
                    throw new IllegalStateException("Unable to open resource: " + filename);
                }

                // adjust the image for size and screen compatibility
                image = adjustImage(image, width, height);

                // add the image to the repository
                imageRepository.put(imageKey, image);
            }
        }

        // draw the image
        graphics.drawImage(image, xLocation, yLocation, width, height, null);


        return true;
    }
}
