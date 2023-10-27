package com.daizzyinfo.recyclerview_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Get_Started extends AppCompatActivity {

    public Button buttonGet_Start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);
        buttonGet_Start = findViewById(R.id.buttonGet_Start);

        buttonGet_Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent= new Intent(Get_Started.this,BottomNavigationBar.class);
                startActivity(intent);
            }
        });


    }
}