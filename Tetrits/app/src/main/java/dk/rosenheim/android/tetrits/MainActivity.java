package dk.rosenheim.android.tetrits;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    EditText inputGameRows, inputGameCols;
    int setGameRows, setGameCols;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputGameRows = (EditText) findViewById(R.id.editRow);
        inputGameCols = (EditText) findViewById(R.id.editCol);
    }

    public void onPlayClick(View view) {
        Intent intent = new Intent(this, TetrisActivity.class);
        int rows = Integer.parseInt(inputGameRows.getText().toString());
        int cols = Integer.parseInt(inputGameCols.getText().toString());

        if (20 <= Integer.parseInt(inputGameRows.getText().toString()) || 12 <= Integer.parseInt(inputGameCols.getText().toString())) {
            intent.putExtra("Rows", rows);
            intent.putExtra("Cols", cols);
            startActivityForResult(intent, 0);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    }
}
