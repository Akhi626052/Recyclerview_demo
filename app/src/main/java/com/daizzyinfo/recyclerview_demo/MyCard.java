package com.daizzyinfo.recyclerview_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.daizzyinfo.recyclerview_demo.CardAdapter;
import com.daizzyinfo.recyclerview_demo.CardModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MyCard extends AppCompatActivity {

    RecyclerView recyclerView;
    List<CardModel> models=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_card);

        recyclerView=findViewById(R.id.recyclerView);

        models.add(new CardModel(R.drawable.food_image2, "dkfjklsa"));
        models.add(new CardModel(R.drawable.food_image2,"dkjlfk"));
        models.add(new CardModel(R.drawable.food_image2, "dkfjklsa"));
        models.add(new CardModel(R.drawable.food_image2,"dkjlfk"));
        models.add(new CardModel(R.drawable.food_image2, "dkfjklsa"));
        models.add(new CardModel(R.drawable.food_image2,"dkjlfk"));

        CardAdapter Adapter = new CardAdapter(models,this);
        LinearLayoutManager manager= new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(Adapter);

    }
}