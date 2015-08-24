package dk.rosenheim.android.drawingacircle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;

import java.util.Random;

public class MyView extends View implements Runnable {
    Context con;
    int x = 100;
    int y = 200;
    int xSpeed = 5;
    int ySpeed = 5;

    int screenWidth, screenHeight;

    Drawable billed;
    int pictHeight, pictWidth;
    Random ran = new Random();

    public MyView(Context context) {
        super(context);
        con = context;
        billed = con.getDrawable(R.drawable.android_logo);
        pictHeight = billed.getMinimumHeight();
        pictWidth = billed.getMinimumWidth();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        screenWidth = w;
        screenHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        canvas.drawCircle(100, 100, 50, paint);

        billed.setBounds(x, y, x + pictWidth, y + pictHeight);
        billed.draw(canvas);

        x += xSpeed;
        if (x > (screenWidth - pictWidth) || x < 0) {
            if (x < 0) x = 0;
            if (x > (screenWidth - pictWidth)) x = (screenWidth - pictWidth);
            xSpeed = -xSpeed;

            if (xSpeed < 0) xSpeed = -(ran.nextInt(20) + 1);
            if (xSpeed > 0) xSpeed = ran.nextInt(20) + 1;
        }

        y = y + ySpeed;
        if (y > (screenHeight - pictHeight) || y < 0) {
            if (y < 0) y = 0;
            if (y > (screenHeight - pictHeight)) y = (screenHeight - pictHeight);

            ySpeed = -ySpeed;
            if (ySpeed < 0) ySpeed = -(ran.nextInt(20) + 1);
            if (ySpeed > 0) ySpeed = ran.nextInt(20) + 1;
        }
    }

    @Override
    public void run() {
        while (true) {
            postInvalidate();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
