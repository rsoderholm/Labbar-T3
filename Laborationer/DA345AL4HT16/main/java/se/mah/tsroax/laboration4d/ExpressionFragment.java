package se.mah.tsroax.laboration4d;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class ExpressionFragment extends Fragment {
    private EditText etNumber1;
    private EditText etNumber2;
    private Spinner spOperator;
    private String operatorStr = "+-*/";
    private String[] operators = {"+","-","*","/"};

    public ExpressionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_expression, container, false);
        etNumber1 = (EditText)view.findViewById(R.id.etNbr1);
        etNumber2 = (EditText)view.findViewById(R.id.etNbr2);
        spOperator = (Spinner)view.findViewById(R.id.spOperator);
        spOperator.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.spinner_row, operators));
        return view;
    }

    public String getNbr1() {
        return etNumber1.getText().toString();
    }
    public String getNbr2()  {
        return etNumber2.getText().toString();
    }
    public String getOperator() {
        return spOperator.getSelectedItem().toString();
    }
    public void setNbr1(String nbr1) {
        etNumber1.setText(nbr1);
    }
    public void setNbr2(String nbr2) {
        etNumber2.setText(nbr2);
    }
    public void setOperator(String operator) {
        int index = operatorStr.indexOf(operator.charAt(0));
        if(index>=0 && spOperator!=null)
            spOperator.setSelection(index);
    }
}
