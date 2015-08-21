package dk.rosenheim.android.drawingacircle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

public class MyView extends View implements Runnable {

    Context con;
    Drawable billed;

    int x = 100;
    int y = 100;
    int picHeight;
    int picWidth;
    int xSpeed = 10;
    int ySpeed = 10;
    int screenWidth = getScreenWidth();
    int screenHeight = getScreenHeight();

    public MyView(Context context) {
        super(context);
        con = context;
        billed = con.getDrawable(R.drawable.android_logo);
        picHeight = billed.getIntrinsicHeight();
        picWidth = billed.getMinimumWidth();
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        screenHeight = h;
        screenWidth = w;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /**
         * Make a circle.
         * Paint paint = new Paint();
         * paint.setColor(Color.RED);
         * canvas.drawCircle(100, 100, 50, paint); */

        billed.setBounds(200, 200, 300, 300);
        billed.draw(canvas);

        x += xSpeed;
        if (x > (screenWidth - picHeight) || x < 0) {
            xSpeed = -xSpeed;
        }
        y += ySpeed;
        if (y > (screenHeight - picWidth) || y < 0) {
            ySpeed = -ySpeed;
        }
    }

    @Override
    public void run() {
        while (true) {
            postInvalidate();
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}