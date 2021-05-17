package com.example.healthapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

// Alejandro Pulido
// Created on 5/6/2021 and last edited on 5/13/2021
public class MyhealthProfilePageActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) // this code is for the Profile page, having a button that takes you to the BMI Calculator
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myhealth_profile_page);

    }

    public void openmyhealthpage()// Method to open the BmiCalculatorActivity, it does intent to start opening to the BmiCalculatorActivity (BMI Calculator)
    //when the BMI Calculator button is clicked you will move from MyHealth Profile to BMI Calculator
    {

    }
}