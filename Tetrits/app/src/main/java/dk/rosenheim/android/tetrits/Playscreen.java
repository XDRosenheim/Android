package dk.rosenheim.android.tetrits;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;

import dk.rosenheim.android.tetrits.Figures.Figure;

public class Playscreen {

	final int MAXWIDTH, MAXHEIGHT,
			COLS, ROWS,
			LEFT_X, TOP_Y,
			BRICK_SIZE;

	Field[][] screenArray;
	Paint paint;
	Drawable[] images;

	public Playscreen(Context context, int w, int h, int rows, int cols) {

		MAXWIDTH = w;
		MAXHEIGHT = h;

		COLS = cols;
		ROWS = rows;

		screenArray = new Field[ROWS][COLS];

		images = new Drawable[7];
		images[0] = context.getDrawable(R.drawable.red);
		images[1] = context.getDrawable(R.drawable.green);
		images[2] = context.getDrawable(R.drawable.blue);
		images[3] = context.getDrawable(R.drawable.purple);
		images[4] = context.getDrawable(R.drawable.yellow);
		images[5] = context.getDrawable(R.drawable.cyan);
		images[6] = context.getDrawable(R.drawable.brown);

		BRICK_SIZE = images[0].getMinimumWidth();

		LEFT_X = (MAXWIDTH - COLS * BRICK_SIZE) / 2;
		TOP_Y = 100; // TODO fix for different sized screens.


	}

	public void paintScreen(Canvas canvas) {
		paint = new Paint();
		paint.setColor(Color.CYAN);
		paint.setStyle(Paint.Style.STROKE);
		paint.setAntiAlias(true);
		paint.setStrokeWidth(2);
		canvas.drawRect(LEFT_X, TOP_Y, LEFT_X + BRICK_SIZE * COLS, TOP_Y + BRICK_SIZE * ROWS, paint);

		for (int row = 0; row < ROWS; row++)
			for (int col = 0; col < COLS; col++) {
				Field f = screenArray[row][col];
				if (f != null) {

					Drawable d = images[f.getColor().ordinal()];

					d.setBounds(LEFT_X + col * BRICK_SIZE,
							TOP_Y + row * BRICK_SIZE,
							LEFT_X + (col * BRICK_SIZE) + BRICK_SIZE,
							TOP_Y + (row * BRICK_SIZE) + BRICK_SIZE);
					d.draw(canvas);
				}
			}

	}

	public void fillScreenArrayRandom() {
		Random rand = new Random();
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				int i = rand.nextInt(images.length + 1);
				if (i == 7) {
					screenArray[row][col] = null;
				} else {
					screenArray[row][col] = new Field(FigColors.values()[i], false);
				}
			}
		}
	}

	public int lineScore() {
		boolean success;
		int score = 0;
		for (int row = 0; row < ROWS; row++) {
			success = true;
			for (int col = 0; col < COLS; col++) {
				if (screenArray[row][col] == null) {
					success = false;
					break;
				}
			}
			if (success) {
				score += 10;
				for (int moveRow = row; moveRow > 0; moveRow--) {
					for (int col = 0; col < COLS; col++) {
						screenArray[moveRow][col] = screenArray[moveRow - 1][col];
					}
				}
				for (int col = 0; col < COLS; col++) {
					screenArray[0][col] = null;
				}
			}
		}
		return score;
	}

	public void placeFigure(Figure fig) {
		for (Point p : fig.figBricksUsed) {
			screenArray[fig.rowPos + p.y][fig.colPos + p.x] = new Field(fig.figColor, false);
		}
	}

	public void removeFigure(Figure fig) {
		for (Point p : fig.figBricksUsed) {
			screenArray[fig.rowPos + p.y][fig.colPos + p.x] = null;
		}
	}

	public boolean isCollision(Figure fig) {
		boolean collision = false;
		for (Point p : fig.figBricksUsed) {
			if (p.x + fig.colPos < 0 || p.x + fig.colPos >= COLS
					|| p.y + fig.rowPos < 0 || p.y + fig.rowPos >= ROWS) {
				collision = true;
				break;
			} else if (screenArray[p.y + fig.rowPos][p.x + fig.colPos] != null) {
				collision = true;
				break;
			}
		}
		return collision;
	}
}