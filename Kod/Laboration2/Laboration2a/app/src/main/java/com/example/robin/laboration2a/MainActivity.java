package com.example.robin.laboration2a;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Instruction[] instructions = new Instruction[3];
    private Button btnPrevious;
    private Button btnNext;
    private TextView tvWhatToDo;
    private TextView tvContent;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeResources();
        initializeComponents();
        initializeListeners();
    }

    private void initializeListeners() {
        btnNext.setOnClickListener(new NextListener());
    }

    private void initializeComponents() {
        btnPrevious = (Button)findViewById(R.id.btnPrevious);
        btnNext = (Button)findViewById(R.id.btnNext);
        tvWhatToDo = (TextView)findViewById(R.id.tvWhatToDo);
        tvContent = (TextView)findViewById(R.id.tvContent);
    }

    private void initializeResources() {
        Resources res = getResources();
        String whatToDo = res.getString(R.string.what_to_do);
        String content = res.getString(R.string.content);
        instructions[0] = new Instruction(whatToDo,content);
        instructions[1] = new Instruction(res.getString(R.string.what_to_do2),res.getString(R.string.content2));
        instructions[2] = new Instruction(res.getString(R.string.what_to_do3),res.getString(R.string.content3));
    }

    public void previousInstruction(View view) {
        index--;
        if(index<0) {
            index = instructions.length-1;
        }
        tvWhatToDo.setText(instructions[index].getWhatToDo());
        tvContent.setText(instructions[index].getContent());
    }

    private class NextListener implements View.OnClickListener {
        public void onClick(View v) {
            index++;
            if(index==instructions.length) {
                index = 0;
            }
            tvWhatToDo.setText(instructions[index].getWhatToDo());
            tvContent.setText(instructions[index].getContent());
        }
    }
}

