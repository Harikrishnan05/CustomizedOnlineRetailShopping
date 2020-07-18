package com.hai.appproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class splashActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
       //supportActionBar()?.hide();
       getSupportActionBar().hide();
        new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               Intent inn=new Intent(splashActivity.this,MainActivity.class);
               startActivity(inn);
           }
       },SPLASH_TIME_OUT);
    }
}