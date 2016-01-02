package Square.Factories;

import io.ResourceRetriever;

/**
 * Factory for creating generic Squares.  This class must be extended (it's only constructor is protected), in order
 * to create more specific factories.
 *
 * Created by fraca_000 on 1/2/2016.
 */
public class SquareFactory {
    /**
     * The ResourceRetriever object represented by the given ClassLoader.
     */
    protected final ResourceRetriever resourceRetreiver;

    /**
     * Constructs a new factory that will create squares who's backing resources are in the provided
     * class loader.
     *
     * @param classLoader The class loader containing the necessary resources
     */
    protected SquareFactory(ClassLoader classLoader) {
        resourceRetreiver = new ResourceRetriever(classLoader);
    }
}
