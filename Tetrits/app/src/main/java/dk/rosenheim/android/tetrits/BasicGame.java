package dk.rosenheim.android.tetrits;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;

public abstract class BasicGame extends View implements Runnable{

    Playscreen playscreen;
    final int COLS, ROWS;
    Context context;
    private boolean quit = false;
    private long sleepMillis = 1000;

    public BasicGame(Context context, int cols, int rows) {
        super(context);
        this.context = context;
        COLS = cols;
        ROWS = rows;
    }

    @Override
    public void run() {
        while (!quit){
            postInvalidate(); // Calls onDraw
            try {
                Thread.sleep(sleepMillis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        update(canvas);
    }

     abstract void update(Canvas canvas);

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        playscreen = new Playscreen(context, w, h, ROWS, COLS);
    }
}
