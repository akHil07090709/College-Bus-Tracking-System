package com.example.cbts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class student3Activity extends AppCompatActivity {
    private Button location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student3);
        location=(Button)findViewById(R.id.locationbtn);
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(student3Activity.this,MapsActivity2.class);//change ACtivity
                startActivity(intent);
            }
        });
    }
}
