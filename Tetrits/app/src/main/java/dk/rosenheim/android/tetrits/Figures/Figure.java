package dk.rosenheim.android.tetrits.Figures;

import android.graphics.Point;

import java.util.ArrayList;

import dk.rosenheim.android.tetrits.FigColors;

public class Figure {
	public int rowPos, colPos;
	public FigColors figColor;
	public ArrayList<Point> figBricksUsed = new ArrayList<Point>();
	ArrayList<Point> figBrickOriginal = new ArrayList<Point>();

	public void reset(int colPos) {
		this.colPos = colPos;
		this.rowPos = 0;
		figBricksUsed.clear();

		for (Point p : figBrickOriginal) {
			figBricksUsed.add(new Point(p));
		}
	}

	public void turnRight() {
		for (Point p : figBricksUsed) {
			int temp = p.x;
			p.x = -p.y;
			p.y = temp;
		}
	}

	public void turnLeft() {
		for (Point p : figBricksUsed) {
			int temp = p.x;
			p.x = p.y;
			p.y = -temp;
		}
	}
}
