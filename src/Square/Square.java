package Square;

import Square.squareRenderers.SquareRenderer;

import java.awt.*;

/**
 * Represents a single square on the Game View.
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


}
