package com.hai.appproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class sellcategoryActivity extends AppCompatActivity {


    FirebaseAuth fauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sellcategory);



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.logout)
        {
            fauth.getInstance().signOut();
            Intent n=new Intent(sellcategoryActivity.this,MainActivity.class);
            startActivity(n);
            finish();
        }
        return super.onOptionsItemSelected(item);
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