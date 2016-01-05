import Square.SquareGrid;
import gameView.GameViewRenderer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Graphics2D;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * Test application for blocks.
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
        frame.setUndecorated(true);
        frame.setSize(screenWidth, screenHeight);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        Graphics2D graphics = (Graphics2D)panel.getGraphics();
        GameViewRenderer renderer = new GameViewRenderer(graphics, screenWidth, screenHeight);

        SquareGrid grid = new SquareGrid(20, 20);

        File file = new File("c:/testFolder/test.grid");

        try (OutputStream outputStream = new FileOutputStream(file);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream)){

            objectOutputStream.writeObject(grid);

        } catch (IOException e) {
            e.printStackTrace();
        }

//        try(InputStream inputStream = new FileInputStream(file);
//                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
//                ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream)) {
//            grid = (SquareGrid)objectInputStream.readObject();
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        renderer.render(grid);
    }
}
