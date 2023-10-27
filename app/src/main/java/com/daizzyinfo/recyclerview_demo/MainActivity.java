package com.daizzyinfo.recyclerview_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.daizzyinfo.recyclerview_demo.activit.AllCategoryRe;
import com.daizzyinfo.recyclerview_demo.response.CategoryResponse;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public ImageView imgpro;
    public ImageView Address;
    public ImageView imgsearch;
    public ImageView ImgNotification;
    public TextView textviewAll;

public TextView textviewAll2;
RecyclerView recyclerView , recyclerViewPopuler;

RecyclerView addrecyclerview;
List<CategoryResponse> modResponse = new ArrayList<CategoryResponse>();
List<PopulerModel> models1 = new ArrayList<>();




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


      /*  recyclerView = findViewById(R.id.recyclerView);
        models.add(new CategoryModel("mango", R.drawable.food));
        models.add(new CategoryModel("adasfdfdsdfd", R.drawable.food));
        models.add(new CategoryModel("adasfdfdsdfd", R.drawable.food));
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        CategoryAdapter adapter = new CategoryAdapter(models, this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);*/

     //  recyclerViewPopuler.setNestedScrollingEnabled(false);
        recyclerViewPopuler = findViewById(R.id.recyclerViewPopuler);

        recyclerViewPopuler.smoothScrollToPosition(0);
        models1.add(new PopulerModel("Cheese Corn Sandwich", R.drawable.food_image1));
        models1.add(new PopulerModel("Cheese Corn Sandwich", R.drawable.food_image1));
        models1.add(new PopulerModel("Cheese Corn Sandwich", R.drawable.food_image1));
        models1.add(new PopulerModel("Cheese Corn Sandwich", R.drawable.food_image1));

        PopularAdapter adapter1 = new PopularAdapter(models1, this);
        GridLayoutManager manager1 = new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false);

        recyclerViewPopuler.setLayoutManager(manager1);
        recyclerViewPopuler.setAdapter(adapter1);


        //        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);


        textviewAll = findViewById(R.id.textviewAll);

        textviewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllCategoryRe.class);
                startActivity(intent);
            }
        });

        textviewAll2 = findViewById(R.id.textviewAll2);

        textviewAll2.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, All_items.class);
                startActivity(intent);
            }
        }));

        ImgNotification = (ImageView) findViewById(R.id.ImgNotification);
        ImgNotification.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyCard.class);
                startActivity(intent);
            }

        }));
        imgsearch=(ImageView)findViewById(R.id.imgsearch);
        imgsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Search_Here.class);
                startActivity(intent);
            }
        });
        Address=findViewById(R.id.Address);
        Address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MyAddress.class);
                startActivity(intent);
            }
        });

        imgpro=findViewById(R.id.imgpro);
        imgpro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AddNewAddress.class);
                startActivity(intent);
            }
        });

    }

}