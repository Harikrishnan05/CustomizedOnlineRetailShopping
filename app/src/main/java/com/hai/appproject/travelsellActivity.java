package com.hai.appproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;

public class travelsellActivity extends AppCompatActivity {

    //
    EditText na,pno,pri,on;
    DatabaseReference reff;
    Button sav;
    //
    Uri Imageurl;
    String url;
    private StorageReference FOLDER;
    private static final int IMAGEBACK =1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travelsell);

        //
        na=findViewById(R.id.Ename);
        pno=findViewById(R.id.Econ);
        pri=findViewById(R.id.Epr);
        on=findViewById(R.id.Eon);
        sav=findViewById(R.id.button6);
        reff= FirebaseDatabase.getInstance().getReference().child("TravelDetails");
        FOLDER= FirebaseStorage.getInstance().getReference().child("Travel");

        sav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final StorageReference Imagename=FOLDER.child(Imageurl.getLastPathSegment());

                Imagename.putFile(Imageurl).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Imagename.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                url=String.valueOf(uri);
                                String id=reff.push().getKey();
                                String name = na.getText().toString();
                                String phone = pno.getText().toString();
                                String price = pri.getText().toString();
                                String available = on.getText().toString();

                                Upload upload = new Upload(name,phone,price,available,url);
                                reff.child(id).setValue(upload);

                                Toast.makeText(travelsellActivity.this,"Uploaded Successfully",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),BuySellActivity.class));




                            }
                        });
                    }
                });
            }
        });
    }

    public void up(View v){
        Intent u=new Intent(Intent.ACTION_GET_CONTENT);
        u.setType("image/*");
        startActivityForResult(u,IMAGEBACK);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==IMAGEBACK){
            if(resultCode==RESULT_OK && data.getData()!=null){
                Toast.makeText(travelsellActivity.this,"Uploading",Toast.LENGTH_SHORT).show();
                Imageurl=data.getData();



            }
        }
    }
}