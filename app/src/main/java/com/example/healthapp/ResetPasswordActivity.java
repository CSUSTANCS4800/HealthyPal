package com.example.healthapp;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.RequestPasswordResetCallback;

public class ResetPasswordActivity extends AppCompatActivity {

    // this is the reset password screen, and it sends a email to your email -Samir
    EditText edEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        edEmail = findViewById(R.id.edEmail);
    }
    public void resetPassword(View view) {
        if( TextUtils.isEmpty(edEmail.getText())){
            edEmail.setError( "Email is required!" );
        }else {
            ParseUser.requestPasswordResetInBackground(edEmail.getText().toString(), new RequestPasswordResetCallback() {
                public void done(ParseException e) {
                    if (e == null) {
                        // An email was successfully sent with reset instructions.
                        Toast.makeText(ResetPasswordActivity.this, "An email was successfully sent with reset instructions.", Toast.LENGTH_LONG).show();
                    } else {
                        // Something went wrong. Look at the ParseException to see what's up.
                        Toast.makeText(ResetPasswordActivity.this, "Something went wrong. Look at the ParseException to see what's up.", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
}