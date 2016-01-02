package Square;

import Square.squareRenderers.DefaultSwingRenderer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.MissingResourceException;

/**
 * Created by fraca_000 on 1/2/2016.
 */
public class ColoredSquare extends Square {
    private Color color;



    public ColoredSquare(Color color) {
        super(new DefaultSwingRenderer(color.getFilename()));
    }

    @Override
    public boolean render(Graphics2D graphics, int xLocation, int yLocation, int width, int height) {
        return renderer.render(graphics, xLocation, yLocation, width, height);
    }


}
