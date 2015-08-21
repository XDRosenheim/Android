package dk.rosenheim.android.drawingacircle;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class GraphicsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphics);

        FrameLayout f1;
        f1 = (FrameLayout) findViewById(R.id.layoutGraphics);
        MyView view = new MyView(this);
        Thread t = new Thread(view);
        t.start();
        f1.addView(view);
    }
}
