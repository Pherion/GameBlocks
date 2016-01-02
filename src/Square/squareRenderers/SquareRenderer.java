package Square.squareRenderers;

import Square.ImageRepository;

import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Transparency;
import java.awt.image.BufferedImage;

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


}
