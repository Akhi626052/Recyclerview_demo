package com.daizzyinfo.recyclerview_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class All_items extends AppCompatActivity {

    public ImageView imgback;
    RecyclerView rvAllitems;
    List<AllModel> models = new ArrayList<>();


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_items);

        rvAllitems = findViewById(R.id.rvAllitems);
        models.add(new AllModel("pizza food",R.drawable.food_src ));
        models.add(new AllModel("pizza food",R.drawable.food_src ));
        models.add(new AllModel("pizza food",R.drawable.food_src ));
        models.add(new AllModel("pizza food",R.drawable.food_src ));

        LinearLayoutManager manager1 = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        AllAdapter allAdapter = new AllAdapter(models,this);
        rvAllitems.setLayoutManager(manager1);
        rvAllitems.setAdapter(allAdapter);

        imgback=findViewById(R.id.imgback);
        imgback.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }





}