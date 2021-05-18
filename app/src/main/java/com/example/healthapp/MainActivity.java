package com.example.healthapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {

    // Declaring views -Moises
//    EditText title;
//    EditText location;
//    EditText description;
//    Button addEvent;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_scheduling);
//
//        title = findViewById(R.id.etTitle);
//        location = findViewById(R.id.etLocation);
//        description = findViewById(R.id.etDescription);
//        addEvent = findViewById(R.id.btnAdd);
//    }


    EditText usernameEditText;
    EditText passwordEditText;
    Button loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Adding new code for scheduling -Moises
//        setContentView(R.layout.activity_scheduling);
//
//        title = findViewById(R.id.etTitle);
//        location = findViewById(R.id.etLocation);
//        description = findViewById(R.id.etDescription);
//        addEvent = findViewById(R.id.btnAdd);
//
//        addEvent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!title.getText().toString().isEmpty() && !location.getText().toString().isEmpty()
//                    && !description.getText().toString().isEmpty()) {
//                } else {
//                    Toast.makeText(MainActivity.this, "Please fill all the fields",
//                            Toast.LENGTH_SHORT).show();
//                }
//            }
//        });


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameEditText = findViewById(R.id.et_username);
        passwordEditText = findViewById(R.id.et_password);
        loginButton=findViewById(R.id.bt_login);




        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!usernameEditText.getText().toString().isEmpty() && !passwordEditText.getText().toString().isEmpty()) {
                    ParseUser.logInInBackground(usernameEditText.getText().toString(), passwordEditText.getText().toString(), new LogInCallback() {
                        @Override
                        public void done(ParseUser user, ParseException e) {
                            if (user != null) {
                                Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_LONG).show();
                                startUserActivity();
                            } else {
                                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }

            }
        });



    }

    private void startUserActivity() {
       Intent intent = new Intent(MainActivity.this, Dashboard.class);
        startActivity(intent);
    }

    public void signup(View view) {
        Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
        startActivity(intent);
    }

    public void forgotPassword(View view) {
        Intent intent = new Intent(MainActivity.this, ResetPasswordActivity.class);
        startActivity(intent);
    }
}
