package dk.rosenheim.android.tetrits.Figures;

import android.graphics.Point;

import dk.rosenheim.android.tetrits.FigColors;

public class FigT extends Figure {
	public FigT(int col) {
		figBrickOriginal.add(new Point(0, 0));
		figBrickOriginal.add(new Point(-1, 0));
		figBrickOriginal.add(new Point(1, 0));
		figBrickOriginal.add(new Point(0, 1));

		figColor = FigColors.BROWN;

		reset(col);
	}
}
