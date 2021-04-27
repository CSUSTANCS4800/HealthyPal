package com.example.healthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class scheduling extends AppCompatActivity {

    // Declaring views -Moises
    EditText title;
    EditText location;
    EditText description;
    Button addEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Adding new code for scheduling -Moises
        // java.text.DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(getApplicationContext());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduling);

        title = findViewById(R.id.etTitle);
        location = findViewById(R.id.etLocation);
        description = findViewById(R.id.etDescription);
        addEvent = findViewById(R.id.btnAdd);

        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!title.getText().toString().isEmpty() && !location.getText().toString().isEmpty() && !description
                        .getText().toString().isEmpty()) {


                    Intent intent = new Intent(Intent.ACTION_EDIT);
                    intent.setData(CalendarContract.Events.CONTENT_URI);
                    intent.putExtra(CalendarContract.Events.TITLE, title.getText().toString());
                    intent.putExtra(CalendarContract.Events.EVENT_LOCATION, location.getText().toString());
                    intent.putExtra(CalendarContract.Events.DESCRIPTION, description.getText().toString());
                    intent.putExtra(CalendarContract.Events.ALL_DAY, true);
                    intent.putExtra(Intent.EXTRA_EMAIL, "test@yahoo.com, test2@yahoo.com, test3@yahoo.com");

                    if(intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    } else {
                        Toast.makeText(scheduling.this, "There is no app that can support this action",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(scheduling.this, "Please fill all the fields",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}