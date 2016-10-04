package com.example.robin.laboration3;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class MainFragment extends Fragment {
    private Button btnColor;
    private TextView tvColor;
    private ListView lvColor;
    private Controller controller;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        tvColor = (TextView)view.findViewById(R.id.tvColor);
        btnColor = (Button)view.findViewById(R.id.btnColor);
        btnColor.setOnClickListener(new ButtonListener());
        lvColor = (ListView)view.findViewById(R.id.lvColor);
        lvColor.setOnItemClickListener(new ListViewListener());
        return view;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setColors(String[] colors) {
        lvColor.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,colors));
    }

    public void setButtonText(String colorName) {
        btnColor.setText(colorName);
    }

    public void setTextViewColor(int color) {
        tvColor.setBackgroundColor(color);
    }

    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            controller.btnColorClicked(btnColor.getText().toString());
        }
    }

    private class ListViewListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            controller.listItemClicked(position);
        }
    }
}
