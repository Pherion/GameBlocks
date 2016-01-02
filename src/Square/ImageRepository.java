package Square;

import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Created by fraca_000 on 1/2/2016.
 */
public class ImageRepository {
    /**
     * Singleton Instance
     */
    private static ImageRepository instance = new ImageRepository();

    /**
     * @return The singleton instance of ImageRepository
     */
    public static ImageRepository getInstance() {
        return instance;
    }

    private Map<String, BufferedImage> imageMap = new HashMap<>();

    /**
     * Private constructor to prevent instantiation.
     * Initializes the map containing images.
     */
    private ImageRepository() {
    }

    /**
     * Places the provided image into the map with the given key.  If the key already exists, this returns false,
     * and does not add the key to the map.
     *
     * @param key The image's key.
     * @param image The image.
     * @return TRUE if the image was added to the map, FALSE if it was not
     */
    public boolean put(String key, BufferedImage image) {
        // make sure the key isn't already in the map
        if(imageMap.containsKey(key)) {
            return false;
        }

        // add the image to the map
        imageMap.put(key, image);

        return true;
    }

    /**
     * @param key The key for which to obtain an image.
     * @return The image referenced by the key, or NULL if the key does not exist.
     */
    public BufferedImage get(String key) {
        return imageMap.get(key);
    }

    /**
     * @param key The key to look for.
     * @return TRUE if the key exists, FALSE otherwise.
     */
    public boolean contains(String key) {
        return imageMap.containsKey(key);
    }
}
