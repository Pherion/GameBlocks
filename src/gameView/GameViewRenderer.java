package gameView;

import Square.SquareGrid;

import java.awt.Graphics2D;

/**
 * Created by fraca_000 on 1/1/2016.
 */
public class GameViewRenderer {
    private int width;
    private int height;
    private Graphics2D graphics;

    /**
     * Constructs a new game view renderer
     * @param graphics The graphics object that will be used to render the game view.
     * @param width The pixel width of the game view.
     * @param height The pixel height of the game view.
     */
    public GameViewRenderer(Graphics2D graphics, int width, int height) {
        this.graphics = graphics;
        this.width = width;
        this.height = height;
    }

    public void render(SquareGrid grid) {
        int numSquaresY = grid.getHeight();
        int numSquaresX = grid.getWidth();

        int squareHeight = height / numSquaresY;
        int squareWidth = width / numSquaresX;

        int upperY = 0;
        int upperX = 0;

        for(int y = 0; y < numSquaresY; y++) {
            for(int x = 0; x < numSquaresX; x++) {
                grid.get(x, y).render(graphics, upperX, upperY, squareWidth, squareHeight);

                upperX += squareWidth;
            }

            upperX = 0;
            upperY += squareHeight;
        }
    }
}
