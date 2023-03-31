package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
hello boys
    private AppCompatEditText etWeight, etHeightFt, etHeightIn;
    private AppCompatButton btnCalc;
    private AppCompatTextView tvResult;
    private LinearLayoutCompat llMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etWeight = findViewById(R.id.etWeight);
        etHeightFt = findViewById(R.id.etHeightFt);
        etHeightIn = findViewById(R.id.etHeightIn);
        btnCalc = findViewById(R.id.btnCalc);
        tvResult = findViewById(R.id.tvResult);
        llMain = findViewById(R.id.llMain);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int weight = Integer.parseInt(etWeight.getText().toString());
                int heightFt = Integer.parseInt(etHeightFt.getText().toString());
                int heightIn = Integer.parseInt(etHeightIn.getText().toString());

                int totalHeightIn = heightFt * 12 + heightIn;
                double totalHeightM = (totalHeightIn * 2.53)/100;

                double bmi = weight/(totalHeightM * totalHeightM);

                if(bmi > 25) {
                    tvResult.setText("You're OverWeight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.OWcolor, null));
                } else if(bmi > 18 && bmi < 25) {
                    tvResult.setText("You're Healthy");
                    llMain.setBackgroundColor(getResources().getColor(R.color.Healthy, null));
                } else {
                    tvResult.setText("You're UnderWeight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.UWcolor, null));
                }
            }
        });

    }
}