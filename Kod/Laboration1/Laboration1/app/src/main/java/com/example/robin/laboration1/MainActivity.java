package com.example.robin.laboration1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private Button btnSummary, btnColor;
    private EditText etName, etPhone, etEmail;
    private TextView tvSummary;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeComponents();
        registerListeners();

    }

    public void initializeComponents() {
        btnSummary = (Button)findViewById(R.id.btnSummary);
        etName = (EditText)findViewById(R.id.etName);
        etPhone = (EditText)findViewById(R.id.etPhone);
        etEmail = (EditText)findViewById(R.id.etEmail);
        tvSummary = (TextView)findViewById(R.id.tvSummary);
        btnColor = (Button)findViewById(R.id.btnColor);

    }

    public void registerListeners() {
        btnColor.setOnClickListener(new ChangeColor());
        btnSummary.setOnClickListener(new ButtonListener());
    }

    private class ButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            String str = summary();
            tvSummary.setText(str);




        }

        private String summary() {
            String res;

            res = "Name: " + etName.getText().toString() + "\n"
                    + "Phone: " + etPhone.getText().toString() + "\n"
                    + "Email: " + etEmail.getText().toString();
            return res;
        }

    }

    private class ChangeColor implements View.OnClickListener {

        private Boolean redColor = true;
        @Override
        public void onClick(View v) {
            if (redColor) {
                tvSummary.setTextColor(Color.BLUE);
            } else {
                tvSummary.setTextColor(Color.RED);
            }
            redColor = !redColor;

        }
    }
}
