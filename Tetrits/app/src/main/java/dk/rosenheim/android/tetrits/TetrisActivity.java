package dk.rosenheim.android.tetrits;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

public class TetrisActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tetris);

        Intent intent = getIntent();
        int cols = intent.getIntExtra("Cols", 12);
        int rows = intent.getIntExtra("Rows", 20);

        Game game = new Game(this, cols, rows);
        FrameLayout fl = (FrameLayout)findViewById(R.id.playLayout);
        fl.addView(game);

        Thread t = new Thread(game);
        t.start();
    }
}
