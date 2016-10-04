package com.example.robin.laboration3;

import android.graphics.Color;

/**
 * Created by tsroax on 2014-09-08.
 */
public class Controller {
    private String[] colorNames = {"RÖD","BLÅ","GUL","GRÖN"};
    private int[] colors = {Color.RED,Color.BLUE,Color.YELLOW,Color.GREEN};
    private MainFragment fragment;

    public Controller(MainFragment fragment) {
        this.fragment=fragment;
        fragment.setController(this);
        fragment.setColors(colorNames);
        fragment.setButtonText(colorNames[0]);
        fragment.setTextViewColor(colors[0]);
    }

    public void listItemClicked(int position) {
        fragment.setButtonText(colorNames[position]);
    }

    public void btnColorClicked(String colorStr) {
        int pos = -1;
        for(int i=0; i< colorNames.length; i++)
            if(colorNames[i].equals(colorStr)) {
                pos = i;
                fragment.setTextViewColor(colors[pos]);
                break;
            }
    }
}
