package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationsForClubs extends AppCompatActivity {

    SQLitehelper sqLitehelper;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrations_for_clubs);

        EditText edtName, edtUsn, edtBranch, edtSection;
        Button btnRegister;

        edtName = findViewById(R.id.edtname);
        edtUsn = findViewById(R.id.edtUsn);
        edtBranch = findViewById(R.id.edtBranch);
        edtSection = findViewById(R.id.edtSection);
        btnRegister = findViewById(R.id.btnRegister);

        // Initialize SQLitehelper
        sqLitehelper = new SQLitehelper(this, "FoodDB.sqlite", null, 1);
        sqLitehelper.queryData("CREATE TABLE IF NOT EXISTS REG (Id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, usn VARCHAR, branch VARCHAR, section VARCHAR, club VARCHAR)");

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve registration details from EditText fields
                String name = edtName.getText().toString().trim();
                String usn = edtUsn.getText().toString().trim();
                String branch = edtBranch.getText().toString().trim();
                String section = edtSection.getText().toString().trim();

                // Assuming you have the club name passed from the previous activity
                String clubName = getIntent().getStringExtra("clubName");

                // Insert registration details into the "REG" table
                if (sqLitehelper != null) {
                    sqLitehelper.insertRegistrationData(name, usn, branch, section, clubName);
                    Toast.makeText(RegistrationsForClubs.this, "Registration successful!", Toast.LENGTH_SHORT).show();
                    finish(); // Close the registration activity if needed
                } else {
                    // Handle the case where sqLitehelper is null
                    Toast.makeText(RegistrationsForClubs.this, "Error: SQLitehelper is null", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}