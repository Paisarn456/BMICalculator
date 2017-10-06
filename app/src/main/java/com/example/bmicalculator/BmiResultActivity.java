package com.example.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BmiResultActivity extends AppCompatActivity {

    TextView showbmi;
    TextView textbmi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);
        Intent intent = getIntent();
        Double BMI = intent.getDoubleExtra("bmi_value", 0);
        String BMItext = intent.getStringExtra("bmi_text");
        showbmi = (TextView)findViewById(R.id.textView);
        showbmi.setText(String.format("ค่า BMI = %.2f",BMI));
        textbmi = (TextView)findViewById(R.id.textView2);
        textbmi.setText("อยู่ในเกณฑ์ " + BMItext);
    }
}
