package dk.rosenheim.android.tetrits;

public class Playscreen {

    final int MAXWIDTH, MAXHEIGHT,
            COLS, ROWS,
            LEFT_X, TOP_Y,
            BRICK_SIZE = 20;

    Field[][] screenArray;

    public Playscreen(int w, int h, int cols, int rows) {

        MAXWIDTH = w;
        MAXHEIGHT = h;

        COLS = cols;
        ROWS = rows;

        LEFT_X = ((MAXWIDTH / 2) - (COLS / 2)) * BRICK_SIZE / 2;
        TOP_Y = 100; // TODO fix for different sized screens.
    }
}