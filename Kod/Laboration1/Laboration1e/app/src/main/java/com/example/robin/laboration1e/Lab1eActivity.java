package com.example.robin.laboration1e;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Lab1eActivity extends AppCompatActivity {
    private Button btnColor, btnSummary;
    private EditText etName, etPhone, etEmail;
    private TextView tvSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1e);
        initializeComponents();
        registerListeners();
    }

    private void initializeComponents() {
        etName = (EditText)findViewById(R.id.etName);
        etPhone = (EditText)findViewById(R.id.etPhone);
        etEmail = (EditText)findViewById(R.id.etEmail);
        btnSummary = (Button)findViewById(R.id.btnSummary);
        btnColor = (Button)findViewById(R.id.btnColor);
        tvSummary = (TextView)findViewById(R.id.tvSummary);
    }

    private void registerListeners() {
        btnSummary.setOnClickListener(new ButtonListener());
        btnColor.setOnClickListener(new ChangeColor());

    }

    private class ButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            String str = summary();
            tvSummary.setText(str);

        }

        private String summary() {
            String res;

            res = "Name: " + etName.getText().toString()
                    + "\nPhone: " + etPhone.getText().toString()
                    + "\nEmail: " + etEmail.getText().toString();
            return res;
        }
    }

    private class ChangeColor implements View.OnClickListener {
        private Boolean colorRed = true;

        @Override
        public void onClick(View v) {
            if(colorRed) {
                tvSummary.setTextColor(Color.BLUE);
            } else {
                tvSummary.setTextColor(Color.RED);
            }
            colorRed = !colorRed;



        }



        }
    }

