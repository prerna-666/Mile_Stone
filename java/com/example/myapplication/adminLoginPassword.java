package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class adminLoginPassword extends AppCompatActivity {

    EditText e1;
    TextView t1;
    Button b1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login_password);

        e1=(EditText) findViewById(R.id.enterpassword);
        t1=(TextView) findViewById(R.id.password);
        b1=(Button) findViewById(R.id.enteringPasswordButton);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String v1 = e1.getText().toString();
                if(e1.getText().toString().equals("admin"))
                {
                    startActivity(new Intent(getApplicationContext(),adminPage.class));
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Password is wrong",Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
}