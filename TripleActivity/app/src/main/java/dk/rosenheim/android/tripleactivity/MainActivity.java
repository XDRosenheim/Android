package dk.rosenheim.android.tripleactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {


    final int requestName = 1, requestGame = 0;

    TextView txtName, txtGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = (TextView) findViewById(R.id.txtName);
        txtGame = (TextView) findViewById(R.id.txtGame);

    }

    public void getName(View view) {
        Intent intent = new Intent(this, nameActivity.class);

        startActivityForResult(intent, requestName);
    }

    public void getGame(View view) {
        Intent intent = new Intent(this, gameActivity.class);
        startActivityForResult(intent, requestGame);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == requestName) {
            if (resultCode == RESULT_OK) {
                String name = data.getStringExtra("Name");
                txtName.setText(getString(R.string.txtNameField) + " " + name);
            }
        }
        if (requestCode == requestGame) {
                String game = data.getStringExtra("Game");
                txtGame.setText(getString(R.string.txtGameField) + " " + game);

        }
    }
}
