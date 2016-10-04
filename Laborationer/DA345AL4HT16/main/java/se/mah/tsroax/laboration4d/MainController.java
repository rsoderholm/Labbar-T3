package se.mah.tsroax.laboration4d;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;

/**
 * Created by tsroax on 2014-09-11.
 */
public class MainController {
    private Activity activity;
    private ResultFragment resultFragment;
    private ExpressionFragment expressionFragment;
    private Resources resources;
    private String resultTitle;
    private static int REQUEST_CODE = 8264899;

    public MainController(Activity activity, ResultFragment resultFragment, ExpressionFragment expressionFragment) {
        this.activity = activity;
        this.resultFragment = resultFragment;
        this.expressionFragment = expressionFragment;
        this.resources = activity.getResources();
        this.resultTitle = resources.getString(R.string.resultTitle);
        resultFragment.setMainController(this);
        resultFragment.setResult(resultTitle);
        resultFragment.setCalculation("");
    }

    public void calculate() {
        Intent intent = new Intent(activity,CalculatorActivity.class);
        intent.putExtra("nbr1",expressionFragment.getNbr1());
        intent.putExtra("nbr2",expressionFragment.getNbr2());
        intent.putExtra("operator",expressionFragment.getOperator());
        activity.startActivityForResult(intent,MainController.REQUEST_CODE);

        // Laboration4e
//        Intent intent = new Intent("se.mah.tsroax.ACTION_CALC");
//        intent.putExtra("nbr1",expressionFragment.getNbr1());
//        intent.putExtra("nbr2",expressionFragment.getNbr2());
//        intent.putExtra("operator",expressionFragment.getOperator());
//        activity.startActivityForResult(intent,MainController.REQUEST_CODE);
    }

    public void result(double result, String calculation) {
        String resultString = resources.getString(R.string.resultTitle) + " " + result;
        resultFragment.setResult(resultString);
        resultFragment.setCalculation(calculation);
    }
}
