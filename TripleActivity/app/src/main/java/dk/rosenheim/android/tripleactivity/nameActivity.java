package dk.rosenheim.android.tripleactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class nameActivity extends Activity {

    TextView myText;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        intent = getIntent();
        myText = (TextView) findViewById(R.id.txtName);
    }

    @Override
    public void onBackPressed() {
        intent.putExtra("Name", myText.getText().toString());
        setResult(RESULT_OK, intent);
        super.onBackPressed();
    }
}
