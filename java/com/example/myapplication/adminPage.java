package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class adminPage extends AppCompatActivity {

    Button addclubs;
    Button addevents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);

        addclubs=(Button) findViewById(R.id.addClubsByAdmin);
        addevents=(Button) findViewById(R.id.addEventsByAdmin);

        addclubs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),addClubsByAdmin.class));
            }
        });

        addevents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),addEventsByAdmin.class));
            }
        });


    }
}