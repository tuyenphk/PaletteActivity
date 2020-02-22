package temple.edu.paletteactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        Intent intent = getIntent();
        String color = intent.getStringExtra(PaletteActivity.EXTRA_COLOR);
        findViewById(R.id.canvasLayout).setBackgroundColor( Color.parseColor(color));

        TextView colorTextView = findViewById(R.id.colorText);
        colorTextView.setText(color);
    }
}
