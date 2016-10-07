package com.example.robin.laboration2b;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class ButtonFragment extends Fragment {
    private Controller controller;
    private Button btnClick;


    public ButtonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_button, container, false);
    }

    private void initializeComponents(View view) {
        btnClick =(Button)view.findViewById(R.id.btnClick);

    }

    private class ButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
          controller.clickMe();
        }
    }

}
