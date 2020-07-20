package com.hai.appproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class buycategoryActivity extends AppCompatActivity {

    FirebaseAuth fauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buycategory);
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
            Intent n=new Intent(buycategoryActivity.this,MainActivity.class);
            startActivity(n);
            finish();
        }
        return super.onOptionsItemSelected(item);
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