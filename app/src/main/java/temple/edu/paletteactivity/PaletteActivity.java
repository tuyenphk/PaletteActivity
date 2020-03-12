package temple.edu.paletteactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PaletteActivity extends AppCompatActivity implements PaletteFragment.PaletteFragmentInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        String[] color_names = res.getStringArray(R.array.color_names_array);
        String[] color_codes = res.getStringArray(R.array.color_codes_array);

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .add(R.id.activityLayout, PaletteFragment.newInstance(color_names,color_codes))
                .commit();
    }

    @Override
    public void onColorSelected(String color) {

        CanvasFragment cF = new CanvasFragment();
        Bundle args = new Bundle();
        args.putString(CanvasFragment.COLOR_KEY, color);
        cF.setArguments(args);

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .addToBackStack(null)
                .add(R.id.activityLayout, cF)
                .commit();
    }
}