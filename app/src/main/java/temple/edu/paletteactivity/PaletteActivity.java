package temple.edu.paletteactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class PaletteActivity extends AppCompatActivity {

    public static final String EXTRA_COLOR = "edu.temple.paletteactivity.EXTRA_COLOR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] colors = {"Red","Blue","Green","White","Grey","Cyan","Magenta","Yellow","Lime","Maroon","Teal", "Purple"};
        final Spinner colorSpinner = findViewById(R.id.colorSpinner);
        final View activityLayout = findViewById(R.id.activityLayout);

        ColorAdapter colorAdapter = new ColorAdapter(this, colors);
        colorSpinner.setAdapter(colorAdapter);

        colorSpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setClass(PaletteActivity.this, CanvasActivity.class);
                intent.putExtra(EXTRA_COLOR, parent.getItemAtPosition(position).toString());
                startActivity(intent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
