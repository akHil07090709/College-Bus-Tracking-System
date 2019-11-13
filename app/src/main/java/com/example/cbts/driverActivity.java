package com.example.cbts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class driverActivity extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private Button  login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);
        email = (EditText)findViewById(R.id.drivereT1);
        password=(EditText)findViewById(R.id.drivereT2);
        login = (Button)findViewById(R.id.driverbtn1);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(email.getText().toString(), password.getText().toString());
            }
        });

    }

    private void validate(String userName, String userPassword){
        if((userName.equals("Admin")) && (userPassword.equals("12345"))){
            Intent intent = new Intent(driverActivity.this,driversActivity.class);
                    startActivity(intent);
        }
        else{
            Toast.makeText(this, "wrong credentials", Toast.LENGTH_SHORT).show();
        }
    }
}
