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
import com.parse.SignUpCallback;

public class MainActivity extends AppCompatActivity {

    EditText usernameEditText;
    EditText passwordEditText;
    Button loginButton;
    Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ParseInstallation.getCurrentInstallation().saveInBackground();
        usernameEditText=findViewById(R.id.et_username);
        passwordEditText=findViewById(R.id.et_password);
        loginButton=findViewById(R.id.bt_submit);
        signUpButton=findViewById(R.id.bt_signUpButton);
        //setting up buttons that connect to activity_main.xml

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
                            //connections login to parse server and see if information is correct
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
                            //connections sign up to parse server and see if information is correct
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