package Square.squareRenderers;

import Square.ImageRepository;
import io.ResourceRetriever;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.MissingResourceException;

/**
 * Represents an abstract square renderer.  Provides utility methods for extracting images from resources,
 * and adjusting them for optimal display.
 *
 * Created by fraca_000 on 1/2/2016.
 */
public abstract class SquareRenderer {
    /**
     * the GraphicsConfiguration object representing the current display's configuration.  Used for adjusting images
     * so that they will render as quickly as possible.
     */
    protected static final GraphicsConfiguration graphicsConfiguration = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();

    /**
     * Static reference to the image repository.
     */
    protected static final ImageRepository imageRepository = ImageRepository.getInstance();

    /**
     * The resource retriever that will be used to extract the image.
     */
    protected final ResourceRetriever resourceRetriever;

    /**
     * Constructs a new SquareRenderer.
     *
     * @param resourceRetriever The ResourceRetriever that will be used by this renderer.
     */
    public SquareRenderer(ResourceRetriever resourceRetriever) {
        this.resourceRetriever = resourceRetriever;
    }

    /**
     * Performs the render.
     */
    public abstract boolean render(Graphics graphics, int xLocation, int yLocation, int width, int height);

    /**
     * Adjusts an image's size and format for the current display.
     *
     * @param image The image to adjust.
     * @param width The new width of the image.
     * @param height The new height of the image.
     *
     * @return The adjusted image.
     */
    protected static BufferedImage adjustImage(BufferedImage image, int width, int height) {
        // adjust the size and format of the image for fastest rendering
        BufferedImage newImage = graphicsConfiguration.createCompatibleImage(width, height, Transparency.TRANSLUCENT);

        // set the image data from the temp image
        newImage.setData(image.getData());

        // return the adjusted image
        return newImage;
    }

    /**
     * Extracts image from resources.
     *
     * @param filename The filename to extract.
     *
     * @return A buffered image from the resource file provided.
     *
     * @throws IOException If there is a problem reading in the file.
     * @throws MissingResourceException If there is a problem locating the file in the resources.
     */
    protected BufferedImage getImageFromResources(String filename) throws IOException, MissingResourceException {
        // read in the image for manipulation
        URL url = resourceRetriever.retrievePath(filename);

        // check if the url is null, meaning that the resource could not be obtained
        if(url == null) {
            throw new MissingResourceException("Unable to open resource file: " + filename, Class.class.getName(), filename);
        }

        // return the BufferedImage
        return ImageIO.read(url);
    }
}
