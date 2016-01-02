package Square.Factories;

import Square.ColoredSquare;
import Square.ImageRepository;

/**
 * Factory specifically for creating the default colored squares supported in this archive.
 *
 * Created by fraca_000 on 1/2/2016.
 */
public class ColoredSquareFactory extends SquareFactory {
    /**
     * Constructs a new factory that is backed by the local resources
     */
    public ColoredSquareFactory() {
        // we use the singleton class ImageRepository to obtain a class loader from
        // this archive.
        super(ImageRepository.getInstance().getClass().getClassLoader());
    }

    /**
     * Constructs a colored square.
     *
     * @param color The color of the square.
     *
     * @return A ColoredSquare object with the given color.
     */
    public ColoredSquare createColoredSquare(ColoredSquare.Color color) {
        return new ColoredSquare(color, resourceRetreiver);
    }
}
