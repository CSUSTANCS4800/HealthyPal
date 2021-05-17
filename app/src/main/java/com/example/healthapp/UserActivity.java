package com.example.healthapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseUser;

public class UserActivity extends AppCompatActivity {

    // Declaring button to logout -Moises
    Button logoutButton;
    TextView welcomeTextView;

    private Button btnMyHealth;

    private Button btnSchedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_acitvity);
        // Connected the XML to the newly created button -Moises
        btnSchedule = findViewById(R.id.btnSchedule);

        // Connected XML to the newly created myHealth button -Moises
        btnMyHealth = findViewById(R.id.btnMyHealth);

        // Click listener to move from main layout to scheduling functionality -Moises
        btnSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this,scheduling.class);
                startActivity(intent);
            }
        });

        btnMyHealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserActivity.this, MyhealthProfilePageActivity.class);
                startActivity(intent);
            }
        });


        logoutButton=findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logOut();
                Intent intent = new Intent(UserActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }
}