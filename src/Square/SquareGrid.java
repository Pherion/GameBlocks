package Square;

import Square.ColoredSquare.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a grid of Square objects.
 *
 * Created by fraca_000 on 1/1/2016.
 */
public class SquareGrid {
    /**
     * Grid of Square objects.
     */
    private List<List<Square>> squareGrid = new ArrayList<>();

    /**
     * Width, in Squares, of the grid.
     */
    private int width;

    /**
     * Height, in Squares, of the grid.
     */
    private int height;

    /**
     * Constructs a new SquareGrid
     *
     * @param height Height in squares.
     * @param width Width in squares.
     */
    public SquareGrid(int height, int width) {
        this.width = width;
        this.height = height;

        // set-up an empty grid
        initializeEmptyGrid();
    }

    /**
     * Initializes the SquareGrid with default squares (display transparent space only).
     */
    private void initializeEmptyGrid() {

        int color = 0;
        for(int y = 0; y < height; y++) {
            squareGrid.add(new ArrayList<>());

            for(int x = 0; x < width; x++) {
                // create the new square and add it to the grid
                squareGrid.get(y).add(new ColoredSquare(Color.values()[color]));

                color++;

                if(color >= Color.values().length) {
                    color = 0;
                }
            }
        }
    }

    /**
     * Sets the square at the given coordinates to the provided square.
     *
     * @param x The x coordinate of the square.
     * @param y The y coordinate of the square.
     * @param square The square object to set.
     *
     * @throws IllegalArgumentException Throw if x or y is out of the bounds of this SquareGrid.
     */
    public void set(int x, int y, Square square) throws IndexOutOfBoundsException, IllegalArgumentException {
        if(square == null) {
            throw new IllegalArgumentException("SquareGrid.set(...) can not accept a null Square object.");
        }
        // verify x and y are within bounds
        if(x > width || y < height || x < 0 || y < 0) {
            throw new IndexOutOfBoundsException("Attempting to set a Square in SquareGrid outside of the bounds " +
                    "of the grid");
        }

        // set the square
        squareGrid.get(y).set(x, square);
    }

    /**
     * Provides the square at the given location.
     *
     * @param x The x position of the square
     * @param y The y position of the square
     *
     * @return The square located at the given position.
     *
     * @throws IndexOutOfBoundsException Thrown if the x or y provided is outside the bounds of the grid.
     */
    public Square get(int x, int y) throws IndexOutOfBoundsException {
        if(x > width || y > height || x < 0 || y < 0) {
            throw new IndexOutOfBoundsException("Attempting to get a Square in SquareGrid outside of the bounds " +
                    "of the grid.  Requested: " + x + ", " + y + "  Actual: " + this.width + ", " + this.height);
        }

        // return the square
        return squareGrid.get(y).get(x);
    }

    /**
     * @return Width of the grid in squares.
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return Height of the grid in squares.
     */
    public int getHeight() {
        return height;
    }
}
