package se.mah.tsroax.laboration4d;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class CalculatorActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CalculatorController controller = new CalculatorController(this);
        if(controller.validInput())
            controller.calculate();
        else {
            setContentView(R.layout.activity_calculator);
            FragmentManager fm = getFragmentManager();
            CalculatorFragment calculatorFragment = (CalculatorFragment)fm.findFragmentById(R.id.fragmentCalculator);
            ExpressionFragment expressionFragment = (ExpressionFragment)fm.findFragmentById(R.id.fragmentExpression);
            controller.init(calculatorFragment, expressionFragment);
        }
    }
}
