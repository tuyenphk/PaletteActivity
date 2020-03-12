package temple.edu.paletteactivity;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class CanvasFragment extends Fragment {
    static final String COLOR_KEY = "color";
    private View canvas;
    private String color;

    public CanvasFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.color = getArguments().getString(COLOR_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.canvas = inflater.inflate(R.layout.fragment_canvas, container, false);

        updateColor(this.color);

        return canvas;
    }

    public void updateColor(String color){
        this.canvas.setBackgroundColor( Color.parseColor(color) );
    }

}
