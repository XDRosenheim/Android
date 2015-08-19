package dk.rosenheim.android.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtWrite;
    Button newBtn, oldBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        oldBtn = (Button) findViewById(R.id.btnOld);
        newBtn = (Button) findViewById(R.id.btnNew);
        newBtn.setOnClickListener(this);
        oldBtn.setOnClickListener(this);
        this.txtWrite = (TextView) findViewById(R.id.txtWrite);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnOld) {
            this.txtWrite.setText("Old Button was pressed.");
        }
        else if(v == newBtn){
            this.txtWrite.setText("New Button was pressed.");
        }
        // else if(((Button)v).getText().equals("Old Button"));
    }
}
