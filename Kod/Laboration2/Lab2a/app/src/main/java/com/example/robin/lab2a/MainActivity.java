package com.example.robin.lab2a;


import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Controller controller;

    private Button btnPrevious;
    private Button btnNext;
    private TextView tvWhatToDo;
    private TextView tvContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        controller = new Controller(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeComponents();
        initializeListeners();
    }

    private void initializeListeners() {
        btnNext.setOnClickListener(new NextListener());
    }

    private void initializeComponents() {
        btnPrevious = (Button) findViewById(R.id.btnPrevious);
        btnNext = (Button) findViewById(R.id.btnNext);
        tvWhatToDo = (TextView) findViewById(R.id.tvWhatToDo);
        tvContent = (TextView) findViewById(R.id.tvContent);
    }



    public void previousInstruction(View view) {
        controller.previousClick();
    }

    public void setWhatToDo(String whatToDo) {
        tvWhatToDo.setText(whatToDo);
    }

    public void setContent(String content) {
        tvContent.setText(content);
    }

    private class NextListener implements View.OnClickListener {
        public void onClick(View v) {
            controller.nextClick();
        }
    }
}
