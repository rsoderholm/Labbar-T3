package se.mah.tsroax.laboration4d;


import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class ResultFragment extends Fragment {
    private MainController controller;
    private ExpressionFragment expressionFragment;
    private Button btnCalculate;
    private TextView tvResult;
    private TextView tvCalculation;

    public ResultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        initializeComponents(view);
        registerListeners();
        Log.d("MainFrag", "MainFragment färdig");
        return view;
    }

    private void initializeComponents(View view) {
        btnCalculate = (Button)view.findViewById(R.id.btnCalculate);
        tvResult = (TextView)view.findViewById(R.id.tvResult);
        tvCalculation = (TextView)view.findViewById(R.id.tvCalculation);
    }

    private void registerListeners() {
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.calculate();
            }
        });
    }

    public void setMainController(MainController controller) {
        this.controller = controller;
    }

    public void setResult(String result) {
        tvResult.setText(result);
    }

    public void setCalculation(String calculation) {
        tvCalculation.setText(calculation);
    }
}
