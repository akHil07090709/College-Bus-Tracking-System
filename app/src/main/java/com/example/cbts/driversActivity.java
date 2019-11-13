package com.example.cbts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class driversActivity extends AppCompatActivity {
    private Button startsharing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drivers);
        startsharing = (Button)findViewById(R.id.Startbtn);
        startsharing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(driversActivity.this,MapsActivity.class);
                startActivity(intent);
            }
        });
    }
}
