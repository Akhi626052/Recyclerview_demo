package com.daizzyinfo.recyclerview_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MyAddress extends AppCompatActivity {

RecyclerView addrecyclerview;
    public Button addnewaddress;
List<MyAddressModel> model= new ArrayList<>();


    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_address);

    addrecyclerview=findViewById(R.id.addrecyclerview);
    model.add(new MyAddressModel("Daizzy info System","Skye Earth corporate Park, 605,AB road,indore, Madhya Pradesh 452010\n"));
        model.add(new MyAddressModel("Daizzy info System","Skye Earth corporate Park, 605,AB road,indore, Madhya Pradesh 452010\n"));
        model.add(new MyAddressModel("Daizzy info System","Skye Earth corporate Park, 605,AB road,indore, Madhya Pradesh 452010\n"));
        MyAddressAdapter adapter =new MyAddressAdapter(model,this);
        LinearLayoutManager manag=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        addrecyclerview.setAdapter(adapter);
        addrecyclerview.setLayoutManager(manag);

        addnewaddress=findViewById(R.id.addnewaddress);
        addnewaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyAddress.this,AddNewAddress.class);
                startActivity(intent);
            }
        });

    }
}