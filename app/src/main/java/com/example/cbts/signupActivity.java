package com.example.cbts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signupActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText useremail;
    private EditText userpassword;
    private Button Register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().setTitle("REGISTRATION");

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();

        useremail= (EditText)findViewById(R.id.studentemaileT1);
        userpassword =(EditText)findViewById(R.id.studentpasswordeT1);
        Register = (Button)findViewById(R.id.userRegister);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(useremail.getText().toString(),userpassword.getText().toString());
            }
        });


    }

    private void validate(String userName,String userPassword){

        mAuth.createUserWithEmailAndPassword(userName,userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(signupActivity.this, "Login Succesfull", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(signupActivity.this,studentActivity.class);
                    startActivity(intent);
                }  else {
                    Toast.makeText(signupActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }




}

