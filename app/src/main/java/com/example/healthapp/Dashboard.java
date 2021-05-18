package com.example.healthapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthapp.myhealth.BmiCalculatorActivity;
import com.parse.ParseUser;

public class Dashboard extends AppCompatActivity {

    // Declaring button to logout -Moises
    Button logoutButton;

    private Button btnMyHealth;

    private Button btnSchedule;

    private Button btnBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        // Connected the XML to the newly created button -Moises
        btnSchedule = findViewById(R.id.btnSchedule);

        // Connected XML to the newly created myHealth button -Moises
        btnMyHealth = findViewById(R.id.btnMyHealth);

        btnBMI = findViewById(R.id.BMI_Calculator_Button);

        logoutButton = findViewById(R.id.logotbutton);

        // Click listener to move from main layout to scheduling functionality -Moises
        btnSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, scheduling.class);
                startActivity(intent);
            }
        });

        btnMyHealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, MyhealthProfilePageActivity.class);
                startActivity(intent);
            }
        });



        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logOut();
                Intent intent = new Intent(Dashboard.this, MainActivity.class);
                startActivity(intent);
            }
        });


        btnBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, BmiCalculatorActivity.class);
                startActivity(intent);
            }
        });
    }
}