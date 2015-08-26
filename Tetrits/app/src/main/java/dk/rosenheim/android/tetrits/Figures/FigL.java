package dk.rosenheim.android.tetrits.Figures;

import android.graphics.Point;

import dk.rosenheim.android.tetrits.FigColors;

public class FigL extends Figure {
	public FigL(int col) {
		figBrickOriginal.add(new Point(0, 0));
		figBrickOriginal.add(new Point(1, 0));
		figBrickOriginal.add(new Point(-1, 0));
		figBrickOriginal.add(new Point(1, 1));

		figColor = FigColors.CYAN;

		reset(col);
	}
}
