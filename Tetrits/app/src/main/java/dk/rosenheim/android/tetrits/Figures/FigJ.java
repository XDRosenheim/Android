package dk.rosenheim.android.tetrits.Figures;

import android.graphics.Point;

import dk.rosenheim.android.tetrits.FigColors;

public class FigJ extends Figure {
	public FigJ(int col) {
		figBrickOriginal.add(new Point(0, 0));
		figBrickOriginal.add(new Point(1, 0));
		figBrickOriginal.add(new Point(-1, 0));
		figBrickOriginal.add(new Point(-1, 1));

		figColor = FigColors.GREEN;

		reset(col);
	}
}
