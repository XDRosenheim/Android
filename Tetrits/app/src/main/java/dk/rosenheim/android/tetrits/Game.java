package dk.rosenheim.android.tetrits;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Game extends BasicGame {
<<<<<<< HEAD
	final int FALL_INTERVAL = 10;
	int fallCounter = 0;
=======
	private int _score = 0;
>>>>>>> parent of 9a23c1b... Fixes!
	private int _xRef, _yRef;
	private boolean turnedOnce;

	final int FALL_INTERVAL = 10;
	int fallCounter = 0;

	public Game(Context context, int cols, int rows) {
		super(context, cols, rows);
	}

	@Override
	void update(Canvas canvas) {
		fallCounter++;
		switch (fallCounter) {
			case FALL_INTERVAL:
				fallCounter = 0;
				figCurrent.rowPos++;
				if (playscreen.isCollision(figCurrent)) {
					figCurrent.rowPos--;
					playscreen.placeFigure(figCurrent);
					figCurrent.reset(COLS / 2);
					figCurrent = figures[ranFig.nextInt(figures.length)];
					score += playscreen.lineScore();
					if (playscreen.isCollision(figCurrent)) quit = true;
				}
				break;
		}
		if (!quit) playscreen.placeFigure(figCurrent);

		Paint p = new Paint();
		p.setColor(Color.WHITE);
		p.setTextSize(30);
		canvas.drawText("Score: " + score, 50, 50, p);

		playscreen.paintScreen(canvas);
		if (!quit) playscreen.removeFigure(figCurrent);

	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {

		int x = (int) event.getX(), y = (int) event.getY();

		switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				_xRef = x;
				_yRef = y;
				turnedOnce = false;
				break;
			case MotionEvent.ACTION_MOVE:
				// Go left!
				if (x - _xRef > playscreen.BRICK_SIZE) {
					figCurrent.colPos++;
					if (playscreen.isCollision(figCurrent)) {
						figCurrent.colPos--;
					}
					_xRef = x;
					_yRef = y;
				}
				// Go right!
				if (_xRef - x > playscreen.BRICK_SIZE) {
					figCurrent.colPos--;
					if (playscreen.isCollision(figCurrent)) {
						figCurrent.colPos++;
					}
					_xRef = x;
					_yRef = y;
				}
				// Get down! Grenade!
				if (_yRef + y > playscreen.BRICK_SIZE * 90){
					figCurrent.rowPos++;
					if (playscreen.isCollision(figCurrent)) {
						figCurrent.rowPos--;
					}
					_yRef = y;
				}
				// Turn right!
				if (_xRef - y > playscreen.BRICK_SIZE){
					if (!turnedOnce){
						figCurrent.turnRight();
						if (playscreen.isCollision(figCurrent)) {
							figCurrent.turnLeft();
						}
					}
					_yRef = y;
					_xRef = x;
				}
				break;
			case MotionEvent.ACTION_UP:
				turnedOnce = true;
				break;
		}

		return true;
	}
}
