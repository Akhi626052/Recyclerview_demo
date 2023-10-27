package com.daizzyinfo.recyclerview_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.daizzyinfo.recyclerview_demo.ui.main.OrderDetailsFragment;

public class Order_Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order__details);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, OrderDetailsFragment.newInstance())
                    .commitNow();




        }
    }
}