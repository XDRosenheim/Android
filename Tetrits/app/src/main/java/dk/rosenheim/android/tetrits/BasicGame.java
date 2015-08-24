package dk.rosenheim.android.tetrits;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

public abstract class BasicGame extends View implements Runnable{

    Playscreen playscreen;
    final int COLS, ROWS;

    public BasicGame(Context context, int cols, int rows) {
        super(context);
        COLS = cols;
        ROWS = rows;
    }

    @Override
    public void run() {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        update(canvas);
    }

     abstract void update(Canvas canvas);

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        playscreen = new Playscreen(w, h, COLS, ROWS);
    }
}
