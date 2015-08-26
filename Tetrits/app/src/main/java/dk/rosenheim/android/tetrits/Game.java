package dk.rosenheim.android.tetrits;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

public class Game extends BasicGame {
	private int _score = 0;
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
		if (fallCounter == FALL_INTERVAL) {
			fallCounter = 0;
			figCurrent.rowPos++;
			if (playscreen.isCollision(figCurrent)) {
				figCurrent.rowPos--;
				playscreen.placeFigure(figCurrent);
				figCurrent.reset(COLS / 2);
				figCurrent = figures[ranFig.nextInt(figures.length)];
				if (playscreen.isCollision(figCurrent)) {
					quit = true;
				}
			}
		}
		if (!quit) {
			playscreen.placeFigure(figCurrent);
			_score += playscreen.lineScore();
			playscreen.paintScreen(canvas);
			playscreen.removeFigure(figCurrent);
		}
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
