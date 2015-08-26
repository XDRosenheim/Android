package dk.rosenheim.android.tetrits.Figures;

import android.graphics.Point;

import dk.rosenheim.android.tetrits.FigColors;

public class FigZ extends Figure {
	public FigZ(int col) {
		figBrickOriginal.add(new Point(0, 0));
		figBrickOriginal.add(new Point(-1, 0));
		figBrickOriginal.add(new Point(0, 1));
		figBrickOriginal.add(new Point(1, 1));

		figColor = FigColors.BLUE;

		reset(col);
	}
}
