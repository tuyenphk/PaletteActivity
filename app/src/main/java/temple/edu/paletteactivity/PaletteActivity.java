package temple.edu.paletteactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class PaletteActivity extends AppCompatActivity {

    static final String EXTRA_COLOR = "temple.edu.paletteactivity.EXTRA_COLOR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        String[] color_names = res.getStringArray(R.array.color_names_array);
        String[] color_codes = res.getStringArray(R.array.color_codes_array);
        String[][] colors = new String[color_names.length][];

        for(int i = 0; i < color_names.length; i++){
            colors[i] = new String[]{color_names[i], color_codes[i]};
        }

        final Spinner colorSpinner = findViewById(R.id.colorSpinner);

        ColorAdapter colorAdapter = new ColorAdapter(this, colors);
        colorSpinner.setAdapter( colorAdapter );

        colorSpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setClass(PaletteActivity.this, CanvasActivity.class);
                intent.putExtra(EXTRA_COLOR, ((String[])parent.getItemAtPosition(position))[1]);
                startActivity(intent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}