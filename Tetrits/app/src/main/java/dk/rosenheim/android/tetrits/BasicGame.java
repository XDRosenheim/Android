package dk.rosenheim.android.tetrits;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Canvas;
import android.view.View;

import java.util.Random;

import dk.rosenheim.android.tetrits.Figures.FigI;
import dk.rosenheim.android.tetrits.Figures.FigJ;
import dk.rosenheim.android.tetrits.Figures.FigL;
import dk.rosenheim.android.tetrits.Figures.FigO;
import dk.rosenheim.android.tetrits.Figures.FigS;
import dk.rosenheim.android.tetrits.Figures.FigT;
import dk.rosenheim.android.tetrits.Figures.FigZ;
import dk.rosenheim.android.tetrits.Figures.Figure;

public abstract class BasicGame extends View implements Runnable, View.OnTouchListener {

	final int COLS, ROWS;
	protected int score = 0;
	protected boolean quit = false;
	Figure[] figures;
	Figure figCurrent;
	Random ranFig = new Random();
	Playscreen playscreen;
<<<<<<< HEAD
	TetrisActivity activity;
=======
	Context context;
	protected boolean quit = false;
>>>>>>> parent of 9a23c1b... Fixes!
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
<<<<<<< HEAD
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Intent intent = activity.getIntent();
		intent.putExtra("Score", score);
		activity.setResult(Activity.RESULT_OK, intent);
		activity.finish();

=======
>>>>>>> parent of 9a23c1b... Fixes!
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
