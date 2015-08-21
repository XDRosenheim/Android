package dk.rosenheim.android.drawingacircle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startTheClass(View view) {
        Intent intent = new Intent(this, GraphicsActivity.class);
        super.startActivity(intent);
    }
}
