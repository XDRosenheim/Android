package dk.rosenheim.android.tripleactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class gameActivity extends Activity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        intent = getIntent();
    }

    public void onRadioButtonClick(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.rbLudo:
                if (checked)
                    intent.putExtra("Game", getString(R.string.gameLudo));
                    setResult(RESULT_OK, intent);
                break;
            case R.id.rbMatador:
                if (checked)
                    intent.putExtra("Game", getString(R.string.gameMatador));
                    setResult(RESULT_OK, intent);
                break;
            case R.id.rbSkak:
                if (checked)
                    intent.putExtra("Game", getString(R.string.gameChess));
                    setResult(RESULT_OK, intent);
                break;
            case R.id.rbBackgammon:
                if (checked)
                    intent.putExtra("Game", getString(R.string.gameBackgammon));
                    setResult(RESULT_OK, intent);
                break;
        }
    }
}
