package se.mah.tsroax.laboration4d;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by tsroax on 2014-09-10.
 */
public class CalculatorController {
    private final String badValue = "Bad value";
    private final String badOperator = "Bad operator";
    private CalculatorActivity activity;
    private CalculatorFragment calculatorFragment;
    private ExpressionFragment expressionFragment;
    private String nbr1Str;
    private String nbr2Str;
    private String operatorStr;
    private double result;
    private String calculation;

    public CalculatorController(CalculatorActivity activity) {
        this.activity = activity;
        readOperandsAndOperator();
    }

    public boolean validInput() {
        return isDouble(nbr1Str) && isDouble(nbr2Str) && isOperator(operatorStr);

    }

    private void returnResult() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("result",result);
        resultIntent.putExtra("calculation",calculation);
        activity.setResult(Activity.RESULT_OK, resultIntent);
        activity.finish();
    }

    private void readOperandsAndOperator() {
        Intent intent = activity.getIntent();
        nbr1Str = intent.getStringExtra("nbr1");
        nbr2Str = intent.getStringExtra("nbr2");
        operatorStr = intent.getStringExtra("operator");
    }

    private boolean isDouble(String nbr1) {
        boolean res = false;
        try {
            Double.parseDouble(nbr1);
            res = true;
        } catch (Exception e) {}
        return res;
    }

    private boolean isOperator(String operator) {
        if(operator!=null && operator.length()==1)
            return "+-*/".indexOf(operator.charAt(0))>=0;
        return false;
    }

    public void calculate() {
        double nbr1 = Double.parseDouble(nbr1Str);
        double nbr2 = Double.parseDouble(nbr2Str);
        switch(operatorStr.charAt(0)) {
            case '+' : result = nbr1+nbr2; break;
            case '-' : result = nbr1-nbr2; break;
            case '*' : result = nbr1*nbr2; break;
            case '/' : result = nbr1/nbr2; break;
        }
        calculation = nbr1Str+operatorStr.charAt(0)+nbr2Str+"="+result;
        returnResult();
    }

    public void newExpression() {
        nbr1Str = expressionFragment.getNbr1();
        nbr2Str = expressionFragment.getNbr2();
        operatorStr = expressionFragment.getOperator();
        if(validInput()) {
            calculate();
        } else {
            result = Double.NaN;
            calculation = "Nbr1=" + nbr1Str + (isDouble(nbr1Str) ? "" : ", "+badValue) + "\n" +
                    "Nbr2=" + nbr2Str + (isDouble(nbr2Str) ? "" : ", "+badValue) + "\n" +
                    "Operator=" + operatorStr + (isOperator(operatorStr) ? "" : badOperator);
            returnResult();
        }
    }

    public void init(CalculatorFragment calculatorFragment, ExpressionFragment expressionFragment) {
        this.calculatorFragment = calculatorFragment;
        this.expressionFragment = expressionFragment;
        this.calculatorFragment.setCalculatorController(this);
        if(isDouble(nbr1Str))
            expressionFragment.setNbr1(nbr1Str);
        if(isDouble(nbr2Str))
            expressionFragment.setNbr2(nbr2Str);
        if(isOperator(operatorStr))
            expressionFragment.setOperator(operatorStr);
    }
}
