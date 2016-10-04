package se.mah.tsroax.laboration4d;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {
    private MainController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getFragmentManager();
        ResultFragment resultFragment = (ResultFragment)fm.findFragmentById(R.id.fragmentMain);
        ExpressionFragment expressionFragment = (ExpressionFragment)fm.findFragmentById(R.id.fragmentExpression);
        controller = new MainController(this, resultFragment, expressionFragment);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        double result=Double.NaN;
        String calculation = "No result";
        if(resultCode == Activity.RESULT_OK) {
            result = data.getDoubleExtra("result", 0);
            calculation = data.getStringExtra("calculation");
        }
        controller.result(result,calculation);
    }

}
