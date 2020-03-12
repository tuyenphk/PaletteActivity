package temple.edu.paletteactivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;


public class PaletteFragment extends Fragment {

    private static final String ARG_PARAM_COLOR_NAME = "color_names";
    private static final String ARG_PARAM_COLOR_CODE = "color_codes";

    private String[][] colors;

    private PaletteFragmentInterface mActivity;

    public PaletteFragment() {
        // Required empty public constructor
    }

    public static PaletteFragment newInstance(String[] color_names, String[] color_codes) {
        PaletteFragment fragment = new PaletteFragment();
        Bundle args = new Bundle();
        args.putStringArray(ARG_PARAM_COLOR_NAME, color_names);
        args.putStringArray(ARG_PARAM_COLOR_CODE, color_codes);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String[] color_names = getArguments().getStringArray(ARG_PARAM_COLOR_NAME);
            String[] color_codes = getArguments().getStringArray(ARG_PARAM_COLOR_CODE);
            this.colors = new String[color_names.length][];
            for(int i = 0; i < color_names.length; i++){
                this.colors[i] = new String[]{color_names[i], color_codes[i]};
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_palette, container, false);

        Spinner colorSpinner = v.findViewById(R.id.colorSpinner);

        ColorAdapter colorAdapter = new ColorAdapter((Context) mActivity, this.colors);
        colorSpinner.setAdapter( colorAdapter );

        colorSpinner.setSelection(0,false);

        colorSpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                mActivity.onColorSelected( ((String[])parent.getItemAtPosition(position))[1] );
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PaletteFragmentInterface) {
            mActivity = (PaletteFragmentInterface) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mActivity = null;
    }

    public interface PaletteFragmentInterface {

        void onColorSelected(String color);
    }
}
