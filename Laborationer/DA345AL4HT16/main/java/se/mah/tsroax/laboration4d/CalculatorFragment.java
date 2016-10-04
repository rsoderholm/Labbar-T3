package se.mah.tsroax.laboration4d;


import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class CalculatorFragment extends Fragment {
    private ExpressionFragment expressionFragment;
    private Button btnCalculate;
    private CalculatorController controller;

    public CalculatorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);
        initializeComponents(view);
        registerListeners();
        return view;
    }

    public void setCalculatorController(CalculatorController controller) {
        this.controller = controller;
    }

    private void initializeComponents(View view) {
        FragmentManager fm = getFragmentManager();
        expressionFragment = (ExpressionFragment)fm.findFragmentById(R.id.fragmentExpression);
        btnCalculate = (Button)view.findViewById(R.id.btnCalculate);
    }

    private void registerListeners() {
        btnCalculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                controller.newExpression();
            }
        });
    }
}
