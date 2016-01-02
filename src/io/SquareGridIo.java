package io;

import Square.SquareGrid;

import java.io.IOException;
import java.net.URL;

/**
 * Created by fraca_000 on 1/2/2016.
 */
public class SquareGridIO {
    public static SquareGrid read(URL fileLocation) throws IOException {
        SquareGrid grid = new SquareGrid(1, 1);

        return grid;
    }

    public static void write(SquareGrid grid, URL fileLocation) throws IOException {

    }
}
