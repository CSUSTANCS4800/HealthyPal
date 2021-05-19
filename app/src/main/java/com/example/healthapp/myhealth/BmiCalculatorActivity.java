package com.example.healthapp.myhealth;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthapp.R;

import java.text.DecimalFormat;

import static com.example.healthapp.myhealth.Health.BMI_CATEGORY_NORMAL_WEIGHT;
import static com.example.healthapp.myhealth.Health.BMI_CATEGORY_OBESE;
import static com.example.healthapp.myhealth.Health.BMI_CATEGORY_OVERWEIGHT;
import static com.example.healthapp.myhealth.Health.BMI_CATEGORY_UNDERWEIGHT;

// Alejandro Pulido
// created on 4/22/21 and last updated on 5/13/21
// written by: Alex
// tested by: Alex
// debugged by: Alex



public class BmiCalculatorActivity extends AppCompatActivity
{
    private EditText weightKgEditText, heightCmEditText;
    private EditText weightLbsEditText, heightFtEditText, heightInEditText;
    private Button calculateButton;
    private TextView categoryTextView;
    private ToggleButton toggleUnitsButton;
    private TextView bmiResultCardView;

    private boolean inMetricUnits;

    @Override
    protected void onCreate(Bundle savedInstanceState)// connected to the ID of the BMI Calculator
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myhealthpage);

        weightKgEditText = findViewById(R.id.weight_kgs);
        heightCmEditText = findViewById(R.id.height_cm);

        weightLbsEditText = findViewById(R.id.weight_lbs);
        heightFtEditText = findViewById(R.id.height_feet);
        heightInEditText = findViewById(R.id.height_inches);

        calculateButton = findViewById(R.id.calculate);
        toggleUnitsButton = findViewById(R.id.toggle_units_button);

        categoryTextView = findViewById(R.id.category);
        bmiResultCardView = findViewById(R.id.results);

        inMetricUnits = true;

        bmiResultCardView.setVisibility(View.GONE);
        updateInputsVisibility(inMetricUnits);
        calculateButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) // this method shows toast messages for a user to see and shows the double value of the strings
            {
                if(inMetricUnits) {
                    if (weightKgEditText.length() == 0 || heightCmEditText.length() == 0) {
                        Toast.makeText(BmiCalculatorActivity.this, "Insert your Weight and Height to Calculate BMI", Toast.LENGTH_SHORT).show();
                    } else {
                        double heightInCms = Double.parseDouble(heightCmEditText.getText().toString());
                        double weightInKgs = Double.parseDouble(weightKgEditText.getText().toString());
                        double bmi = Health.getInstance().calculateBMIMetric(heightInCms, weightInKgs);
                        displayBMI(bmi);
                    }
                }else
                        {
                            if (weightLbsEditText.length() == 0 || heightFtEditText.length() == 0 || heightInEditText.length() == 0)
                            {
                                Toast.makeText(BmiCalculatorActivity.this, "Insert your Weight and Height to Calculate BMI", Toast.LENGTH_SHORT).show();
                        }else
                            {
                                double heightFeet = Double.parseDouble(heightFtEditText.getText().toString());
                                double heightInches = Double.parseDouble(heightInEditText.getText().toString());
                                double weightLbs = Double.parseDouble(weightLbsEditText.getText().toString());
                                double bmi = Health.getInstance().calculateBMIImperial(heightFeet, heightInches, weightLbs);
                                displayBMI(bmi);
                            }

                        }
                }

            });

        toggleUnitsButton.setOnClickListener((View v) -> { // toggle button to show what card view show up depending if you use imperial or metric units
            inMetricUnits = !inMetricUnits;
            updateInputsVisibility(inMetricUnits);
        });
    }

    private void updateInputsVisibility(boolean inMetricUnits) // Visibility of what Textview should be displayed on the BMI Calculator
    {
        if (inMetricUnits) {
            heightCmEditText.setVisibility(View.VISIBLE);
            weightKgEditText.setVisibility(View.VISIBLE);
            weightLbsEditText.setVisibility(View.GONE);
            heightFtEditText.setVisibility(View.GONE);
            heightInEditText.setVisibility(View.GONE);
        } else {
            heightCmEditText.setVisibility(View.GONE);
            weightKgEditText.setVisibility(View.GONE);
            weightLbsEditText.setVisibility(View.VISIBLE);
            heightFtEditText.setVisibility(View.VISIBLE);
            heightInEditText.setVisibility(View.VISIBLE);
        }
    }

    private void displayBMI(double bmi)// displays the BMI value and the color background and the decimal format for the BMI value
    {
        bmiResultCardView.setVisibility(View.VISIBLE);
        DecimalFormat df = new DecimalFormat("###.##");
        bmi= Double.parseDouble(df.format(bmi));

        //bmiResultCardView.setText(String.format("%.2f", bmi));
        bmiResultCardView.setText(String.valueOf(bmi)); // displays the BMI value in the appropriate card view

        String BMI_Category = Health.getInstance().bmiGroup(bmi);
        categoryTextView.setText(BMI_Category);

        switch (BMI_Category)// this will assign appropriate color backgrounds depending on the user BMI value category
        {
            case BMI_CATEGORY_UNDERWEIGHT:
                bmiResultCardView.setBackgroundColor(Color.BLUE);
                break;
            case BMI_CATEGORY_NORMAL_WEIGHT:
                bmiResultCardView.setBackgroundColor(Color.GREEN);
                break;
            case BMI_CATEGORY_OVERWEIGHT:
                bmiResultCardView.setBackgroundColor(Color.YELLOW);
                break;
            case BMI_CATEGORY_OBESE:
                bmiResultCardView.setBackgroundColor(Color.RED);
                break;
        }
    }
}

