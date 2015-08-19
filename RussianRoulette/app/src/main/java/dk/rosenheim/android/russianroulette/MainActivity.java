package dk.rosenheim.android.russianroulette;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends Activity {

    TextView txtWasHeHurt;
    RelativeLayout myLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myLayout = (RelativeLayout)findViewById(R.id.activityMain);
        txtWasHeHurt = (TextView)findViewById(R.id.txtWasHeHurt);
    }

    public void shoot(View v){
        Random randWasHeHurt = new Random();
        int wasHeHurt = randWasHeHurt.nextInt((5 - 0) + 1) + 0;
        if (wasHeHurt == 3) {
            txtWasHeHurt.setText(R.string.txtWasHeHurtTrue);
            myLayout.setBackgroundColor(Color.RED);
        }
        else{
            txtWasHeHurt.setText(R.string.txtWasHeHurtFalse);
            myLayout.setBackgroundColor(Color.TRANSPARENT);
        }
    }
}
