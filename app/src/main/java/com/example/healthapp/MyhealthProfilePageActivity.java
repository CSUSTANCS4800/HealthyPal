package com.example.healthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.healthapp.myhealth.BmiCalculatorActivity;

// Alejandro Pulido
// Created on 5/6/2021 and last edited on 5/13/2021
public class MyhealthProfilePageActivity extends AppCompatActivity {
    private Button BMI_Calculator_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) // this code is for the Profile page, having a button that takes you to the BMI Calculator
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myhealth_profile_page);

        BMI_Calculator_Button = findViewById(R.id.BMI_Calculator_Button); // BMI button is created and linked from BmiCalculatorActivity(BMI Calculator page)
        BMI_Calculator_Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)// onClick to know what openmyhealthpage method will be opening
            {
                openmyhealthpage();
            }
        });

    }

    public void openmyhealthpage()// Method to open the BmiCalculatorActivity, it does intent to start opening to the BmiCalculatorActivity (BMI Calculator)
                                    //when the BMI Calculator button is clicked you will move from MyHealth Profile to BMI Calculator
    {
        Intent intent = new Intent(this, BmiCalculatorActivity.class);
        startActivity(intent);
        finish();
    }
}