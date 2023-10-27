package com.daizzyinfo.recyclerview_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Search_Here extends AppCompatActivity {

    RecyclerView recyclerView;

    List<SearchHereModel> models =new ArrayList<>();



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_here);

        recyclerView=findViewById(R.id.recyclerView);
        models.add(new SearchHereModel(R.drawable.food_src, "dkhfl"));
        models.add(new SearchHereModel(R.drawable.food_src, "dkhfl"));
        models.add(new SearchHereModel(R.drawable.food_src, "dkhfl"));
        models.add(new SearchHereModel(R.drawable.food_src, "dkhfl"));
        models.add(new SearchHereModel(R.drawable.food_src, "dkhfl"));

        LinearLayoutManager manager= new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        SearchHereAdapter adapter =new SearchHereAdapter(models,this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

    }
}