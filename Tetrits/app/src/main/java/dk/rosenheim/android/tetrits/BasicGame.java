package dk.rosenheim.android.tetrits;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

import java.util.Random;

import dk.rosenheim.android.tetrits.Figures.*;

public abstract class BasicGame extends View implements Runnable, View.OnTouchListener {

	final int COLS, ROWS;
	Figure[] figures;
	Figure figCurrent;
	Random ranFig = new Random();

	Playscreen playscreen;
	TetrisActivity activity;
	protected boolean quit = false;
	private long sleepMillis = 50;

	public BasicGame(TetrisActivity activity, int cols, int rows) {
		super(activity);
		this.activity = activity;
		COLS = cols;
		ROWS = rows;

		figures = new Figure[7];
		figures[0] = new FigO(COLS / 2);
		figures[1] = new FigJ(COLS / 2);
		figures[2] = new FigL(COLS / 2);
		figures[3] = new FigS(COLS / 2);
		figures[4] = new FigZ(COLS / 2);
		figures[5] = new FigI(COLS / 2);
		figures[6] = new FigT(COLS / 2);

		figCurrent = figures[ranFig.nextInt(7)];

		setOnTouchListener(this);
	}

	@Override
	public void run() {
		while (!quit) {
			postInvalidate();
			try {
				Thread.sleep(sleepMillis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		activity.finish();

	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		update(canvas);
	}

	abstract void update(Canvas canvas);

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		playscreen = new Playscreen(activity, w, h, ROWS, COLS);
	}
}
