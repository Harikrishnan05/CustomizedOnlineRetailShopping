package com.hai.appproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class sellcategoryActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sellcategory);



    }
    public void furn(View v){
        Intent f=new Intent(this, furnsellActivity.class);
        startActivity(f);
    }
    public void books(View v){
        Intent boo=new Intent(this,booksellActivity.class);
        startActivity(boo);
    }
    public void cloth(View v){
        Intent clo=new Intent(this,clothsellActivity.class);
        startActivity(clo);
    }
    public void watch(View v){
        Intent wat=new Intent(this,watchsellActivity.class);
        startActivity(wat);
    }
    public void trav(View v){
        Intent tr=new Intent(this,travelsellActivity.class);
        startActivity(tr);
    }
}