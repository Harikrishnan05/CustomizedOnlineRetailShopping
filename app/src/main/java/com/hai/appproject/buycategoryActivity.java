package com.hai.appproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class buycategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buycategory);
    }
    public void furn(View v){
        Intent f=new Intent(this, furnbuyActivity.class);
        startActivity(f);
    }
    public void books(View v){
        Intent f=new Intent(this, bookbuyActivity.class);
        startActivity(f);
    }
    public void cloth(View v){
        Intent f=new Intent(this, clothbuyActivity.class);
        startActivity(f);
    }
    public void watch(View v){
        Intent f=new Intent(this,watchbuyActivity.class);
        startActivity(f);
    }
    public void trav(View v){
        Intent f=new Intent(this, travelbuyActivity.class);
        startActivity(f);
    }

}