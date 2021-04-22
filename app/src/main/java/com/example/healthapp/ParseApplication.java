package com.example.healthapp;

import com.parse.Parse;
import android.app.Application;

public class ParseApplication extends Application {

    // Initializes Parse SDK as soon as the application is created
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("igdYBhtVwHioVDoDzFaUJu2vJpsNvnHi5ipOZKHl")
                .clientKey("ZbCsy6w2AVBnCHmVP8P71twz4ZVTWVagCB0sXlfX")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}