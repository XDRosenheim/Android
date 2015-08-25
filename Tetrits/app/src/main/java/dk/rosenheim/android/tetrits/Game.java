package dk.rosenheim.android.tetrits;

import android.content.Context;
import android.graphics.Canvas;

public class Game extends BasicGame {
    private int score;

    public Game(Context context, int cols, int rows) {
        super(context, cols, rows);
    }

    @Override
    void update(Canvas canvas) {
        //Paint paint = new Paint();
        //paint.setColor(Color.RED);
        // canvas.drawText("Test", 200, 200, paint);
        playscreen.fillScreenArrayRandom();
        score += playscreen.lineScore();
        playscreen.paintScreen(canvas);
    }
}
