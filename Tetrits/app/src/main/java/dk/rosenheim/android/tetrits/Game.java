package dk.rosenheim.android.tetrits;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Game extends BasicGame {
    public Game(Context context, int cols, int rows) {
        super(context, cols, rows);
    }

    @Override
    void update(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawText("Test", 200, 200, paint);
    }
}
