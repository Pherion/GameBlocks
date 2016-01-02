package Square;

import Square.squareRenderers.DefaultSwingRenderer;

import java.awt.Graphics;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Represents a colored square
 *
 * Created by fraca_000 on 1/2/2016.
 */
public class ColoredSquare extends Square {
    private Color color;

    /**
     * Serial Version UID
     */
    private static final long serialVersionUID = 7561871881650263368L;

    /**
     * @param color The color for this square.
     */
    public ColoredSquare(Color color) {
        super(new DefaultSwingRenderer(color.getFilename()));
        this.color = color;
    }

    @Override
    public boolean render(Graphics graphics, int xLocation, int yLocation, int width, int height) {
        return renderer.render(graphics, xLocation, yLocation, width, height);
    }


    /**
     * Enumeration to represent the square colored images available in the resources of this archive.
     *
     * Created by fraca_000 on 1/2/2016.
     */
    public enum Color {
        BLUE("images/blueSquare.png"),
        RED("images/redSquare.png"),
        WHITE("images/whiteSquare.png"),
        BLACK("images/blackSquare.png"),
        GREEN("images/greenSquare.png"),
        PURPLE("images/purpleSquare.png"),
        ORANGE("images/orangeSquare.png"),
        YELLOW("images/yellowSquare.png"),
        TRANSPARENT("images/transparentSquare.png");

        /**
         * The filename of the colored image.
         */
        private String filename;

        /**
         * @param filename The colored image's filename.
         */
        Color(String filename) {
            this.filename = filename;
        }

        /**
         * @return The filename specific to the given color.
         */
        public String getFilename() {
            return filename;
        }
    }

    @Override
    public void writeObject(ObjectOutputStream out) throws IOException {
        out.writeObject(color);
    }

    @Override
    public void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        color = (Color)in.readObject();
        setRenderer(new DefaultSwingRenderer(color.getFilename()));
    }
}
