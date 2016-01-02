import Square.SquareGrid;
import gameView.GameViewRenderer;

import javax.swing.*;
import java.awt.*;

/**
 *
 * Created by fraca_000 on 1/1/2016.
 */
public class GraphicsBlocksTestApplication {
    private static int screenWidth = 500;
    private static int screenHeight = 500;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.add(panel);

        SquareGrid grid = new SquareGrid(20, 20);

        frame.setUndecorated(true);
        frame.setSize(screenWidth, screenHeight);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        Graphics2D graphics = (Graphics2D)panel.getGraphics();
        GameViewRenderer renderer = new GameViewRenderer(graphics, screenWidth, screenHeight);

        renderer.render(grid);
    }
}
