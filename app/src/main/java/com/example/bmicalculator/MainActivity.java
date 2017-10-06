package com.example.bmicalculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mHeightEditText, mWeightEditText;
    private Button mCalculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHeightEditText = (EditText) findViewById(R.id.height_edit_text);
        mWeightEditText = (EditText) findViewById(R.id.weight_edit_text);
        mCalculateButton = (Button) findViewById(R.id.calculate_button);

        mCalculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String heightText = mHeightEditText.getText().toString();
                String weightText = mWeightEditText.getText().toString();
                Double height = Double.valueOf(heightText);
                Double weight = Double.valueOf(weightText);

                Double bmi = weight / ((height / 100) * (height / 100));
                String bmiText = getbmiText(bmi);
                String result = String.format("ค่า BMI ที่ได้คือ %.2f\n\nอยู่ในเกณฑ์ : %s",bmi,bmiText);
/*
                String result = "ค่า BMI ที่ได้คือ" + String.valueOf(bmi);
                result += "\n\n อยู่ในเกณฑ์ : " + bmiText;
*/
/*                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("BMI Result");
                dialog.setMessage(result);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();
*/
                Intent intent = new Intent(MainActivity.this,BmiResultActivity.class);
                intent.putExtra("bmi_value",bmi);
                intent.putExtra("bmi_text",bmiText);
                startActivity(intent);
            }
        });
    }

    private String getbmiText(Double bmi) {
        String bmiText = " ";
        if(bmi < 18.5){
            bmiText = "น้ำหนักน้อยกว่าปกติ";
        }else if(bmi < 25){
            bmiText = "น้ำหนักปกติ";
        }else if(bmi < 30){
            bmiText = "น้ำหนักมากกว่าปกติ (ท้วม)";
        }else{
            bmiText = "น้ำหนักมากกว่าปกติมาก (อ้วน)";
        }
        return bmiText;
    }

}
