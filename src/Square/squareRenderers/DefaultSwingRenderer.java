package Square.squareRenderers;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.Buffer;

/**
 *
 * Created by fraca_000 on 1/2/2016.
 */
public class DefaultSwingRenderer extends SquareRenderer {
    private String filename;
    private BufferedImage image;

    public DefaultSwingRenderer(String filename) {
        this.filename = filename;
    }

    @Override
    public boolean render(Graphics graphics, int xLocation, int yLocation, int width, int height) {
        try {
            if(image == null) {
                String imageKey = filename.concat(":").concat(Integer.toString(width)).concat(",").concat(Integer.toString(height));

                if (imageRepository.contains(imageKey)) {
                    image = imageRepository.get(imageKey);
                } else {
                    // extract the image from resources
                    image = getImageFromResources(filename);

                    // adjust the image for size and screen compatibility
                    image = adjustImage(image, width, height);

                    // add the image to the repository
                    imageRepository.put(imageKey, image);
                }

                if (image == null) {
                    return false;
                }
            }

            // draw the image
            graphics.drawImage(image, xLocation, yLocation, width, height, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }
}
