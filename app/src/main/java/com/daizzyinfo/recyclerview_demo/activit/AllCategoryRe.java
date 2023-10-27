package com.daizzyinfo.recyclerview_demo.activit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.daizzyinfo.recyclerview_demo.R;
import com.daizzyinfo.recyclerview_demo.adapter.AllCategoryAdapter;
import com.daizzyinfo.recyclerview_demo.response.AllCategoriesResponse;
import com.daizzyinfo.recyclerview_demo.response.CategoryResponse;
import com.daizzyinfo.recyclerview_demo.retrofit.ApiRequest;
import com.daizzyinfo.recyclerview_demo.retrofit.RetrofitRequest;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllCategoryRe extends AppCompatActivity {

    public static final String TAG = AllCategoryRe.class.getSimpleName();
    public ImageView imgback;
    RecyclerView recyclerViewAllCategories;
    List<CategoryResponse> categoryResponses = new ArrayList<CategoryResponse>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_page);
        AllCategoriesAPI();

        recyclerViewAllCategories = findViewById(R.id.recyclerViewAllCategories);
/*
        models1.add(new AllCategoryModel("Fast Foods",R.drawable.food2));
        models1.add(new AllCategoryModel("Fast Foods",R.drawable.food2));
        models1.add(new AllCategoryModel("Fast Foods",R.drawable.food2));
        models1.add(new AllCategoryModel("Fast Foods",R.drawable.food2));
        models1.add(new AllCategoryModel("Fast Foods",R.drawable.food2));
        models1.add(new AllCategoryModel("Fast Foods",R.drawable.food2));
        models1.add(new AllCategoryModel("Fast Foods",R.drawable.food2));
        models1.add(new AllCategoryModel("Fast Foods",R.drawable.food2));
        models1.add(new AllCategoryModel("Fast Foods",R.drawable.food2));
        models1.add(new AllCategoryModel("Fast Foods",R.drawable.food2));*/


     /*   LinearLayoutManager manager1 =new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        AllCategoryAdapter homeAdapter=new AllCategoryAdapter(models1,this);
        recyclerViewAllCategories.setLayoutManager(manager1);
        recyclerViewAllCategories.setAdapter(homeAdapter);*/

        imgback=findViewById(R.id.imgback);
        imgback.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                finish();

            }
        });


    }
    public void AllCategoriesAPI(){
        List<CategoryResponse> categoryResponses = new ArrayList<CategoryResponse>();
       ApiRequest apiRequest = RetrofitRequest.getRetrofit().create( ApiRequest.class);
        Call<CategoryResponse> call = apiRequest.getCategory( "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.IjIi.JfakD98H1B3RWE6yG4gdaaVlkHhwQr5SdpuXQ23n_4U");
        call.enqueue(new Callback<CategoryResponse>() {

            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {

                Log.e(TAG, "onResponse------------");
                CategoryResponse  caresponse = response.body();

             //   Log.e("AllCategoryRe", "onResponse"+response.body().getData().toString());
                //Toast.makeText(AllCategoryRe.this, "onResponse", Toast.LENGTH_SHORT).show();
                if (response.body().getData().size() >= 0) {

                    //Toast.makeText(AllCategoryRe.this, "onahfldhkk", Toast.LENGTH_SHORT).show();

                    for (int i = 0; i < response.body().getData().size(); i++) {

                        categoryResponses.add(caresponse);
                     //   Toast.makeText(AllCategoryRe.this, "success fully ", Toast.LENGTH_SHORT).show();


                    }
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AllCategoryRe.this,LinearLayoutManager.VERTICAL,false);
                    AllCategoryAdapter allCategoryAdapter = new AllCategoryAdapter(categoryResponses,AllCategoryRe.this);
                    recyclerViewAllCategories.setLayoutManager(linearLayoutManager);
                    recyclerViewAllCategories.setAdapter(allCategoryAdapter);
                    allCategoryAdapter.notifyDataSetChanged();




                }
                else {


                    Toast.makeText(AllCategoryRe.this, "Hellow ", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {

                Log.e("AllCategoryRe", "onFailure"+t.getMessage());

            }
        });





    }



}