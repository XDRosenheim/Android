package dk.rosenheim.android.tripleactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static dk.rosenheim.android.tripleactivity.gameActivity.*;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtName = (TextView) findViewById(R.id.txtName);
        TextView txtGame = (TextView) findViewById(R.id.txtGame);

        if (favoriteGame != null){
            txtGame.setText(txtGame.getText().toString() + favoriteGame.toString());
        }

        if (nameActivity.txtName != null){
            txtName.setText(txtName.getText().toString() + txtName.toString());
        }

    }

    public void getName(View view){
        Intent intent = new Intent(this, nameActivity.class);
        startActivity(intent);
    }

    public void getGame(View view){
        Intent intent = new Intent(this, gameActivity.class);
        startActivity(intent);
    }
}
