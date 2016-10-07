package com.example.robin.laboration2b;

import android.widget.TextView;

/**
 * Created by robin on 2016-10-05.
 */

public class Controller {
    private TextView tvClick;
    private int buttonClicks;

    public void clickMe() {
        buttonClicks++;
        tvClick.setText(buttonClicks);




    }
}
