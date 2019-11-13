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

public class studentActivity extends AppCompatActivity {
    private Button registerbtn;
    private FirebaseAuth mAuth;
    private EditText email;
    private EditText password;
    private Button signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();

        if(user != null){
            finish();
            Intent intent = new Intent(studentActivity.this,student3Activity.class);
            startActivity(intent);
        }

        email=(EditText)findViewById(R.id.studenteT1);
        password=(EditText)findViewById(R.id.studenteT2);
        signin = (Button)findViewById(R.id.driverbtn1);
        registerbtn = (Button)findViewById(R.id.studentregisterbtn);

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(studentActivity.this,signupActivity.class);
                startActivity(intent);
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(email.getText().toString(),password.getText().toString());
            }
        });


    }
    private void validate(String userName,String userPassword){

        mAuth.signInWithEmailAndPassword(userName,userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(studentActivity.this, "Login Succesfull", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(studentActivity.this,student3Activity.class);
                    startActivity(intent);
                }  else {
                    Toast.makeText(studentActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
