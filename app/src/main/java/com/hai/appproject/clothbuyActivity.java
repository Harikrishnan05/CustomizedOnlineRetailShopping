package com.hai.appproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class clothbuyActivity extends AppCompatActivity {


    private RecyclerView mRecyclerview;
    private DatabaseReference mRef;
    FirebaseDatabase mfireDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothbuy);
        mRef= FirebaseDatabase.getInstance().getReference().child("ClothDetails");
        mRef.keepSynced(true);
        mRecyclerview = (RecyclerView)findViewById(R.id.recyclerview);
        mRecyclerview.setHasFixedSize(true);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        mfireDatabase = FirebaseDatabase.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Blog,ViewHolder> firebaseRecyclerAdapter= new FirebaseRecyclerAdapter<Blog, ViewHolder>(
                Blog.class,
                R.layout.blow_row,
                ViewHolder.class,
                mRef
        ) {
            @Override
            protected void populateViewHolder(ViewHolder viewHolder, final Blog blog, final int i) {
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });
                viewHolder.setDetails(getApplicationContext(),blog.getName(),blog.getMobile(),blog.getPrice(),blog.getAvailable(),blog.getUrl());


            }
        };
        mRecyclerview.setAdapter(firebaseRecyclerAdapter);
    }
}