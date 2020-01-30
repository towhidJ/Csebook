package com.example.csebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class StartingActivity extends AppCompatActivity {

    public static int SPLASH_TIME_OUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(StartingActivity.this, MainActivity.class) ;
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
