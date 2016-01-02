package io;

import java.net.URL;

/**
 * This class is designed for implementation within individual applications that store items in their archive.
 *
 * Created by fraca_000 on 1/2/2016.
 */
public class ResourceRetriever {
    /**
     * The class loader to be used when retrieving resources.
     */
    ClassLoader classLoader;

    /**
     * Constructs a new resource retreiver.
     *
     * @param classLoader The class loader to be used.
     */
    public ResourceRetriever(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    /**
     * Converts a string resource identifier into an appropriate URL.
     *
     * @param resource The string to use in extraction of the resource.
     *
     * @return URL path to the resource.
     */
    public URL retrievePath(String resource) {
        return classLoader.getResource(resource);
    }
}
