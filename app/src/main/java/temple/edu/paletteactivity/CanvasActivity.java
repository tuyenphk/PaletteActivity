package temple.edu.paletteactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        Intent intent = getIntent();
        String color = intent.getStringExtra(PaletteActivity.EXTRA_COLOR);
        findViewById(R.id.canvasLayout).setBackgroundColor( Color.parseColor(color) );
    }
}
