package dk.rosenheim.android.tetrits;

public class Field {
    private FigColors brickColor;
    private boolean permanent;

    public Field(FigColors color, boolean permanent) {
        this.brickColor = color;
        this.permanent = permanent;
    }

    public FigColors getColor() {
        return brickColor;
    }

    public boolean getPermanent() {
        return permanent;
    }
}
