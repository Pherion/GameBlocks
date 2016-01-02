package gameView;

import Square.SquareGrid;

import java.awt.*;

/**
 * Renderer for a game view.
 *
 * Created by fraca_000 on 1/1/2016.
 */
public class GameViewRenderer {
    private int width;
    private int height;
    private Graphics graphics;

    /**
     * Constructs a new game view renderer.
     *
     * @param graphics The graphics object that will be used to render the game view.
     * @param width The pixel width of the game view.
     * @param height The pixel height of the game view.
     */
    public GameViewRenderer(Graphics graphics, int width, int height) {
        this.graphics = graphics;
        this.width = width;
        this.height = height;
    }

    /**
     * Renders the provided Square Grid.
     *
     * @param grid The grid to render.
     */
    public void render(SquareGrid grid) {
        // extract the size of the grid.
        int numSquaresY = grid.getHeight();
        int numSquaresX = grid.getWidth();

        // calculate the size of each square
        int squareHeight = height / numSquaresY;
        int squareWidth = width / numSquaresX;

        // set initial display coordinates
        int upperY = 0;
        int upperX = 0;

        // loop through rows
        for(int y = 0; y < numSquaresY; y++) {
            // loop through columns
            for(int x = 0; x < numSquaresX; x++) {
                // attempt to render the given square
                grid.get(x, y).render(graphics, upperX, upperY, squareWidth, squareHeight);

                // increment the x position
                upperX += squareWidth;
            }

            // reset x position, and increment y
            upperX = 0;
            upperY += squareHeight;
        }
    }
}
