package com.example.healthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.provider.CalendarContract;


import com.parse.ParseUser;

public class UserActivity extends AppCompatActivity {

    // Declaring button to logout -Moises
    Button logoutButton;
    TextView welcomeTextView;

    private Button btnSchedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_acitvity);
        // Connected the XML to the newly created button -Moises
        btnSchedule = findViewById(R.id.btnSchedule);

        // Click listener to move from main layout to scheduling functionality -Moises
        btnSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this,scheduling.class);
                startActivity(intent);
            }
        });


        logoutButton=findViewById(R.id.logoutButton);
        welcomeTextView=findViewById(R.id.welcomeTextView);
        String welcomeMessage="Welcome "+ ParseUser.getCurrentUser().getUsername();
        welcomeTextView.setText(welcomeMessage);
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