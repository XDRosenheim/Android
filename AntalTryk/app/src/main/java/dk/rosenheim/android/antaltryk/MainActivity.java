package dk.rosenheim.android.antaltryk;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    Button btnTotal;
    int totalTaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalTaps = 0;
        btnTotal = (Button)findViewById(R.id.button);
        btnTotal.setOnClickListener(this);
        btnTotal.setText(""+totalTaps);
    }

    @Override
    public void onClick(View v) {
        totalTaps++;
        btnTotal.setText(""+totalTaps);
    }
}
