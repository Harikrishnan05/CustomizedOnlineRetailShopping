package com.hai.appproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BuySellActivity extends AppCompatActivity {
    Button btnsell,btnbuy;

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
}