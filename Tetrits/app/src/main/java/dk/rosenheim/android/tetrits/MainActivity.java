package dk.rosenheim.android.tetrits;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    EditText inputGameCols, inputGameRows;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputGameCols = (EditText) findViewById(R.id.editCol);
        inputGameRows = (EditText) findViewById(R.id.editRow);
    }

    public void onPlayClick(View view) {
        Intent intent = new Intent(this, TetrisActivity.class);
        int rows = Integer.parseInt(inputGameRows.getText().toString());
        int cols = Integer.parseInt(inputGameCols.getText().toString());

        if (20 <= Integer.parseInt(inputGameRows.getText().toString()) || 12 <= Integer.parseInt(inputGameCols.getText().toString())) {
            intent.putExtra("Cols", cols);
            intent.putExtra("Rows", rows);
            startActivityForResult(intent, 0);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    }
}
