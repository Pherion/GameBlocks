package Square;

import com.sun.istack.internal.NotNull;

/**
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

    private String filename;

    private Color(String filename) {
        this.filename = filename;
    }

    /**
     * @returnThe filename specific to the given color.
     */
    @NotNull
    public String getFilename() {
        return filename;
    }
}