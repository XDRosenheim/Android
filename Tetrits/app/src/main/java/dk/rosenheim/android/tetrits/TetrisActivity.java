package dk.rosenheim.android.tetrits;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class TetrisActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tetris);

        Intent intent = getIntent();
        int rows = intent.getIntExtra("Rows", 20);
        int cols = intent.getIntExtra("Cols", 12);
    }
}
