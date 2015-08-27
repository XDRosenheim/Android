package dk.rosenheim.android.tetrits;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends Activity {

	EditText inputGameCols, inputGameRows;
	TextView txtScore;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		txtScore = (TextView) findViewById(R.id.highScore);

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
	protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
		int score = intent.getIntExtra("Score", 0);
		txtScore.setText(getString(R.string.txtHighscore) + " " + score);
		writeToFile("" + score);
	}

	private void writeToFile(String data) {
		try {
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("highscores.txt", Context.MODE_PRIVATE));
			outputStreamWriter.write(data);
			outputStreamWriter.close();
		}
		catch (IOException e) {
			Log.e("Exception", "File write failed: " + e.toString());
		}
	}
}
