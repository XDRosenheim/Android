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
	Context context;
	protected boolean quit = false;
	private long sleepMillis = 50;

	public BasicGame(Context context, int cols, int rows) {
		super(context);
		this.context = context;
		COLS = cols;
		ROWS = rows;
		//SetBackgroundColor(Color.BLACK);

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
