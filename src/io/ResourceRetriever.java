package io;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.MissingResourceException;

/**
 * Created by fraca_000 on 1/2/2016.
 */
public class ResourceRetriever {
    private static final ResourceRetriever resourceRetriever = new ResourceRetriever();

    public static ResourceRetriever getInstance() {
        return resourceRetriever;
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
    public BufferedImage getImageFromResources(String filename) throws IOException, MissingResourceException {
        // read in the image for manipulation
        URL url = getClass().getClassLoader().getResource(filename);

        // check if the url is null, meaning that the resource could not be obtained
        if(url == null) {
            throw new MissingResourceException("Unable to open resource file: " + filename, getClass().getName(), filename);
        }

        // return the BufferedImage
        return ImageIO.read(url);
    }
}
