package Square;

import Square.squareRenderers.SquareRenderer;

import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Represents a single square on the Game View.  Sub classes must implement serializable, and use the
 * setRenderer(...) method to complete deserialization of the object.
 *
 * Created by fraca_000 on 12/31/2015.
 */
public abstract class Square {
    /**
     * The square renderer that will be used to render this square.
     */
    protected SquareRenderer renderer;

    /**
     * Constructs a new square.
     *
     * @param renderer The renderer to be used.
     */
    protected Square(SquareRenderer renderer) {
        this.renderer = renderer;
    }

    /**
     * Default constructor for deserialization.
     */
    protected Square() {}

    /**
     * Renders the given Square.
     *
     * @param graphics The graphics object used to render the square.
     * @param xLocation The x location of the square.
     * @param yLocation The y location of the square.
     * @param width The width of the image.
     * @param height The height of the image.
     *
     * @return TRUE if the square was rendered, FALSE if it was not.
     */
    public abstract boolean render(Graphics graphics, int xLocation, int yLocation, int width, int height);

    /**
     * @param renderer Sets the renderer.
     */
    public void setRenderer(SquareRenderer renderer) {
        this.renderer = renderer;
    }

    /**
     * Writes the Square to an output stream for serialization.
     *
     * @param out The output stream.
     *
     * @throws IOException If there is an issue writing the object.
     */
    public abstract void writeObject(ObjectOutputStream out) throws IOException ;

    /**
     * Reads the Square in from a serialized input stream.
     *
     * @param in The input stream.
     *
     * @throws IOException If there is an error with the input stream.
     * @throws ClassNotFoundException If the input stream does not represent an object of the apropriate type.
     */
    public abstract void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException;
}
