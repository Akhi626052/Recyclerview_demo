package com.daizzyinfo.recyclerview_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CustomAlertDialog extends AppCompatActivity {
    TextView cancel,lg_No,Yes,tvs_id;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_alert_dialog);

        cancel=findViewById(R.id.cancel);
        lg_No=findViewById(R.id.lg_No);
        Yes=findViewById(R.id.Yes);
        tvs_id=findViewById(R.id.tvs_id);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                finish();
            }
        });



    }
}