package dk.rosenheim.android.tripleactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class nameActivity extends Activity {

    public static String personName;
    TextView myText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        myText = (TextView)findViewById(R.id.txtName);
    }

    @Override
    public void onBackPressed() {
        personName = myText.getText().toString();
        super.onBackPressed();
    }
}
