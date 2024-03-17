package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtWeight,edtHeight,edtHeightIN;
        TextView txtResult;
        AppCompatButton btn_bmi;
        LinearLayout llMain;

        edtWeight = findViewById(R.id.edtWeight);
        edtHeight = findViewById(R.id.edtHeight);
        edtHeightIN = findViewById(R.id.edtHeightIN);
        txtResult = findViewById(R.id.txtResult);
        btn_bmi = findViewById(R.id.btn_bmi);
        llMain = findViewById(R.id.llMain);

        btn_bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int wt = Integer.parseInt(edtWeight.getText().toString());
              int ft = Integer.parseInt(edtHeight.getText().toString());
              int in =Integer.parseInt(edtHeightIN.getText().toString());

              int totalIn = 12 * ft + in;
              double totalCm = totalIn*2.53;
              double totalM = totalCm/100;

              double bmi = wt/(totalM*totalM);

              if(bmi>25){
                  txtResult.setText("You are Overweight");
                  llMain.setBackgroundColor(getResources().getColor(R.color.clrO));
              }else if(bmi<18){
                  txtResult.setText("You are UnderWeight");
                  llMain.setBackgroundColor(getResources().getColor(R.color.clrU));
              }else{
                  txtResult.setText("You are Healthy");
                  llMain.setBackgroundColor(getResources().getColor(R.color.cluH));
              }
            }
        });

    }
}