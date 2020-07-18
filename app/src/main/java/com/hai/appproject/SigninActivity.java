package com.hai.appproject;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

public class SigninActivity extends AppCompatActivity {
    EditText emailid,password;
    Button btnSignUp;
    TextView tvLogIn;
    FirebaseAuth mFirebaseAuth;
     String email="",pwd="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        mFirebaseAuth=FirebaseAuth.getInstance();
        emailid=findViewById(R.id.editTextTextEmailAddress3);
        password=findViewById(R.id.editTextTextPassword);
        btnSignUp=findViewById(R.id.button);
        tvLogIn=findViewById(R.id.textView);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email=emailid.getText().toString();
                pwd=password.getText().toString();
                Toast.makeText(SigninActivity.this,email+" "+pwd,Toast.LENGTH_SHORT).show();
Log.d("mail",email);
                Log.d("pas",pwd);
                if(email.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(SigninActivity.this,"Fields are empty",Toast.LENGTH_SHORT).show();
                }
                else if(email.isEmpty()){
                    emailid.setError("Enter EmailId");
                    emailid.requestFocus();
                }
                else if(pwd.isEmpty()){
                    password.setError("Enter Password");
                    password.requestFocus();
                }
                else if(!(email.isEmpty() && pwd.isEmpty())){
                    mFirebaseAuth.createUserWithEmailAndPassword(email,pwd).addOnCompleteListener(SigninActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(SigninActivity.this,"Signin Unsuccessful,,,TryAgain",Toast.LENGTH_SHORT).show();
                            }
                            else{

                                   Toast.makeText(SigninActivity.this,"Signin successful",Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(SigninActivity.this,MainActivity.class));
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(SigninActivity.this,"Error Occurred",Toast.LENGTH_SHORT).show();

                }
            }
        });
        tvLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SigninActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}