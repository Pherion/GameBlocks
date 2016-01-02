package Square;

import Square.squareRenderers.SquareRenderer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.MissingResourceException;

/**
 * Created by fraca_000 on 12/31/2015.
 */
public abstract class Square {


    protected SquareRenderer renderer;

    protected Square(SquareRenderer renderer) {
        this.renderer = renderer;
    }



    /**
     * Renders the given Square
     * @param graphics
     * @param xLocation
     * @param yLocation
     * @param width
     * @param height
     * @return
     */
    public abstract boolean render(Graphics2D graphics, int xLocation, int yLocation, int width, int height);


}
