package dk.rosenheim.android.changecolour;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends Activity implements View.OnClickListener {

    Boolean Skift = true;
    Button myButton;
    TextView myText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myButton = (Button)findViewById(R.id.btnMyButton);
        myButton.setOnClickListener(this);

        myText = (TextView)findViewById(R.id.txtMyText);
    }

    @Override
    public void onClick(View v) {
        if (Skift){
            myText.setBackgroundColor(Color.CYAN);
            myText.setTextColor(Color.BLACK);
            Skift = false;
        }
        else{
            myText.setBackgroundColor(Color.RED);
            myText.setTextColor(Color.BLUE);
            Skift = true;
        }
    }
}
