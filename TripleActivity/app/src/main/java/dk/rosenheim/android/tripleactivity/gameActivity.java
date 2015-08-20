package dk.rosenheim.android.tripleactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class gameActivity extends Activity {

    public static String favoriteGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

    }

    public void onRadioButtonClick(View view){
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rbLudo:
                if (checked)
                    favoriteGame = "Ludo";
                    break;
            case R.id.rbMatador:
                if (checked)
                    favoriteGame = "Matador";
                    break;
            case R.id.rbSkak:
                if (checked)
                    favoriteGame = "Skak";
                    break;
            case R.id.rbBackgammon:
                if (checked)
                    favoriteGame = "Backgammon";
                    break;
        }
    }
}
