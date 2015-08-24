package dk.rosenheim.android.tetrits;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

public abstract class BasicGame extends View implements Runnable{

    Playscreen playscreen;

    public BasicGame(Context context, int cols, int rows) {
        super(context);
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
}
