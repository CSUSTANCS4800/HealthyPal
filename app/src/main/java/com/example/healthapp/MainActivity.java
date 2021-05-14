package com.example.healthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

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
    Button signUpButton;

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
        //ParseInstallation.getCurrentInstallation().saveInBackground();
        usernameEditText=findViewById(R.id.et_username);
        passwordEditText=findViewById(R.id.et_password);
        loginButton=findViewById(R.id.bt_submit);
        signUpButton=findViewById(R.id.bt_signUpButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!usernameEditText.getText().toString().isEmpty() && !passwordEditText.getText().toString().isEmpty()){
                    ParseUser.logInInBackground(usernameEditText.getText().toString(), passwordEditText.getText().toString(), new LogInCallback() {
                        @Override
                        public void done(ParseUser user, ParseException e) {
                            if (user!=null){
                                Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_LONG).show();
                                startUserActivity();
                            }else {
                                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }

            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!usernameEditText.getText().toString().isEmpty() && !passwordEditText.getText().toString().isEmpty()){
                    ParseUser user = new ParseUser();
                    user.setUsername(usernameEditText.getText().toString());
                    user.setPassword(passwordEditText.getText().toString());
                    user.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e==null){
                                Toast.makeText(getApplicationContext(),"Sign Up Successful",Toast.LENGTH_LONG).show();
                                startUserActivity();
                            }else {
                                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }


            }
        });

    }

    private void startUserActivity() {
        Intent intent = new Intent(MainActivity.this,UserActivity.class);
        startActivity(intent);
    }
}