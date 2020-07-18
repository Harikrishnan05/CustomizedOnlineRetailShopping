package com.hai.appproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText emailid,password;
    Button btnLogin;
    TextView tvSignup;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAuth=FirebaseAuth.getInstance();
        emailid=findViewById(R.id.editTextTextEmailAddress3);
        password=findViewById(R.id.editTextTextPassword);
        btnLogin=findViewById(R.id.button);
        tvSignup=findViewById(R.id.textView);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=emailid.getText().toString();
                String pwd=password.getText().toString();

                if(isConnected())
                {
                    //Toast.makeText(MainActivity.this,"connected",Toast.LENGTH_SHORT).show();
                 if(email.isEmpty()){
                    emailid.setError("Enter EmailId");
                    emailid.requestFocus();
                 }
                 else if(pwd.isEmpty()){
                    password.setError("Enter Password");
                    password.requestFocus();
                 }
                 else if(email.isEmpty() && pwd.isEmpty()){
                     Toast.makeText(MainActivity.this,"Fields are empty",Toast.LENGTH_SHORT).show();
                 }
                 else if(!(email.isEmpty() && pwd.isEmpty())){
                     mFirebaseAuth.signInWithEmailAndPassword(email,pwd).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                 Toast.makeText(MainActivity.this,"Login Error,try again!!",Toast.LENGTH_SHORT).show();
                             }
                             else{
                                 Intent inToHome = new Intent(MainActivity.this, BuySellActivity.class);
                                startActivity(inToHome);
                            }
                         }
                    });
                 }
                 else{
                    Toast.makeText(MainActivity.this,"Error Occurred",Toast.LENGTH_SHORT).show();

                 }
                }
                else
                {
                    AlertDialog.Builder on = new AlertDialog.Builder(MainActivity.this);
                    on.setTitle("Warning")
                            .setMessage("Please enable the Internet  ")
                            .setPositiveButton("Turn ON", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent om = new Intent(Settings.ACTION_NETWORK_OPERATOR_SETTINGS);
                                    startActivity(om);
                                }
                            })
                            .setIcon(R.drawable.network);
                    AlertDialog m = on.create();
                    m.show();

                }
            }
        });

        tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intSignUp=new Intent(MainActivity.this,SigninActivity.class);
                startActivity(intSignUp);
            }
        });
    }
//


    public boolean isConnected() {
        boolean connected = false;
        try {
            ConnectivityManager cm = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nInfo = cm.getActiveNetworkInfo();
            connected = nInfo != null && nInfo.isAvailable() && nInfo.isConnected();
            return connected;
        } catch (Exception e) {
            Log.e("Connectivity Exception", e.getMessage());
        }
        return connected;
    }
}