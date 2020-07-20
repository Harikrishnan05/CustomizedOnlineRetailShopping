package com.hai.appproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class BuySellActivity extends AppCompatActivity {
    Button btnsell,btnbuy;
    FirebaseAuth fauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buysell);
        btnsell=findViewById(R.id.button2);
        btnbuy=findViewById(R.id.button3);

        btnsell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(BuySellActivity.this, sellcategoryActivity.class);
                startActivity(b);
            }
        });
        btnbuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(BuySellActivity.this, buycategoryActivity.class);
                startActivity(b);
            }
        });
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
            Intent n=new Intent(BuySellActivity.this,MainActivity.class);
            startActivity(n);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}