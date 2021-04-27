package com.example.healthapp.myhealth;

//Alejandro Pulido
// created on 4/22/21 and last updated on 4/25/21

public class Health
{
    public static final Health instance = new Health();

    private static final int INCHES_IN_FOOT = 12;
    private static final int BMI_IMPERIAL_WEIGHT_SCALAR = 703;

    public static final String BMI_CATEGORY_UNDERWEIGHT = "Underweight";
    public static final String BMI_CATEGORY_NORMAL_WEIGHT = "Normal Weight";
    public static final String BMI_CATEGORY_OVERWEIGHT = "Overweight";
    public static final String BMI_CATEGORY_OBESE = "Obese";

    public static Health getInstance()
    {
            return instance;
    }

    public double calculateBMIMetric(double heightCm, double weightKg) //// math formula from find BMI value in Metric units
    {
        return (weightKg / ((heightCm) * (heightCm)));
    }

    public double calculateBMIImperial(double height_feet, double height_inches, double weight_lbs) // math formula from find BMI value in Imperial units
    {
        double totalHeightInInches = (height_feet * INCHES_IN_FOOT) + height_inches;
        return (BMI_IMPERIAL_WEIGHT_SCALAR * weight_lbs) / (totalHeightInInches * totalHeightInInches);
    }
        public String bmiGroup(double bmi) // BMI vaule that determines which BMI catagory user belongs to.
        {
            if (bmi < 18.5) {
                return BMI_CATEGORY_UNDERWEIGHT;
            } else if (bmi >= 18.5 && bmi < 25) {
                return BMI_CATEGORY_NORMAL_WEIGHT;
            } else if (bmi >= 25 && bmi < 30){
                return BMI_CATEGORY_OVERWEIGHT;
            } else {
                return BMI_CATEGORY_OBESE;
            }
        }



}
