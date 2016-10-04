package com.example.robin.laboration3;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        FragmentManager fm = getFragmentManager();
        MainFragment fragment = (MainFragment)fm.findFragmentById(R.id.fragment);
        new Controller(fragment);
    }

}
