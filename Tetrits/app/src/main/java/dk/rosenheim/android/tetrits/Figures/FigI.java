package dk.rosenheim.android.tetrits.Figures;

import android.graphics.Point;

import dk.rosenheim.android.tetrits.FigColors;

public class FigI extends Figure {
	public FigI(int col) {
		figBrickOriginal.add(new Point(0, 0));
		figBrickOriginal.add(new Point(-1, 0));
		figBrickOriginal.add(new Point(1, 0));
		figBrickOriginal.add(new Point(2, 0));

		figColor = FigColors.RED;

		reset(col);
	}
}
