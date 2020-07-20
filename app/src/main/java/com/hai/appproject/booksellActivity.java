package com.hai.appproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;

public class booksellActivity extends AppCompatActivity {

    //
    EditText na,pno,pri,on,mi;
    DatabaseReference reff;
    Button sav;
    //
    Uri Imageurl;
    String url;
    private StorageReference FOLDER;
    private static final int IMAGEBACK =1 ;
    FirebaseAuth fauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booksell);

        //
        na=findViewById(R.id.Ename);
        pno=findViewById(R.id.Econ);
        pri=findViewById(R.id.Epr);
        on=findViewById(R.id.Eon);
        mi=findViewById(R.id.Mai);
        sav=findViewById(R.id.button6);
        reff= FirebaseDatabase.getInstance().getReference().child("BooksDetails");
        FOLDER= FirebaseStorage.getInstance().getReference().child("Books");

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
                                String mail=mi.getText().toString();

                                Upload upload = new Upload(name,phone,price,available,mail,url);
                                reff.child(id).setValue(upload);

                                Toast.makeText(booksellActivity.this,"Uploaded Successfully",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),BuySellActivity.class));




                            }
                        });
                    }
                });
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
            Intent n=new Intent(booksellActivity.this,MainActivity.class);
            startActivity(n);
            finish();
        }
        return super.onOptionsItemSelected(item);
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
                Toast.makeText(booksellActivity.this,"Uploading",Toast.LENGTH_SHORT).show();
                Imageurl=data.getData();



            }
        }
    }
}