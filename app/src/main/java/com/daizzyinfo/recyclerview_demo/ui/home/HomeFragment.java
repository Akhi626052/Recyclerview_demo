package com.daizzyinfo.recyclerview_demo.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.daizzyinfo.recyclerview_demo.AddNewAddress;
import com.daizzyinfo.recyclerview_demo.activit.AllCategoryRe;
import com.daizzyinfo.recyclerview_demo.All_items;
import com.daizzyinfo.recyclerview_demo.adapter.CategoryAdapter;
import com.daizzyinfo.recyclerview_demo.model.BannerBottomModel;
import com.daizzyinfo.recyclerview_demo.model.BannerTopModel;
import com.daizzyinfo.recyclerview_demo.model.CategoryModel;
import com.daizzyinfo.recyclerview_demo.MyAddress;
import com.daizzyinfo.recyclerview_demo.MyCard;
import com.daizzyinfo.recyclerview_demo.PopularAdapter;
import com.daizzyinfo.recyclerview_demo.PopulerModel;
import com.daizzyinfo.recyclerview_demo.R;
import com.daizzyinfo.recyclerview_demo.Search_Here;
import com.daizzyinfo.recyclerview_demo.databinding.FragmentHomeBinding;
import com.daizzyinfo.recyclerview_demo.response.BannerTopBottomResponse;
import com.daizzyinfo.recyclerview_demo.response.CategoryResponse;
import com.daizzyinfo.recyclerview_demo.retrofit.ApiRequest;
import com.daizzyinfo.recyclerview_demo.retrofit.RetrofitRequest;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

   ImageView banner1,banner2;
    TextView address_id;
    public ImageView imgpro;
    public ImageView Address;
    public ImageView imgsearch;
    public ImageView ImgNotification;
    public TextView textviewAll;
    public TextView textviewAll2;
    RecyclerView recyclerView , recyclerViewPopuler;
    RecyclerView addrecyclerview;
    List<CategoryModel> models = new ArrayList<>();
    List<PopulerModel> models1 = new ArrayList<>();
    // Banner slider
    List<BannerTopModel> bannerTop = new ArrayList<>();

    List<BannerBottomModel> bannerBottom = new ArrayList<>();


    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        Categories();
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        View root = binding.getRoot();
        banner1=root.findViewById(R.id.banner1);
        banner2=root.findViewById(R.id.banner2);

        recyclerView = root.findViewById(R.id.recyclerView);



  /*      recyclerView = root.findViewById(R.id.recyclerView);
        models.add(new CategoryModel("mango", R.drawable.food));
        models.add(new CategoryModel("adasfdfdsdfd", R.drawable.food));
        models.add(new CategoryModel("adasfdfdsdfd", R.drawable.food));
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        CategoryAdapter adapter = new CategoryAdapter(models, getContext());

        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter); */


        recyclerViewPopuler = root.findViewById(R.id.recyclerViewPopuler);
//        recyclerViewPopuler.smoothScrollToPosition(0);
        models1.add(new PopulerModel("Cheese Corn Sandwich", R.drawable.food_image1));
        models1.add(new PopulerModel("Cheese Corn Sandwich", R.drawable.food_image1));
        models1.add(new PopulerModel("Cheese Corn Sandwich", R.drawable.food_image1));
        models1.add(new PopulerModel("Cheese Corn Sandwich", R.drawable.food_image1));
        PopularAdapter adapter1 = new PopularAdapter(models1, getContext());
        recyclerViewPopuler.setNestedScrollingEnabled(false);
        GridLayoutManager manager1 = new GridLayoutManager(getContext(), 2, LinearLayoutManager.VERTICAL, false);
        recyclerViewPopuler.setLayoutManager(manager1);
        recyclerViewPopuler.setAdapter(adapter1);


        //        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);


        textviewAll = root.findViewById(R.id.textviewAll);

        textviewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AllCategoryRe.class);
                startActivity(intent);
            }
        });

        textviewAll2 = root.findViewById(R.id.textviewAll2);

        textviewAll2.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), All_items.class);
                startActivity(intent);
            }
        }));



        ImgNotification = (ImageView) root.findViewById(R.id.ImgNotification);
        ImgNotification.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MyCard.class);
                startActivity(intent);
            }

        }));
        imgsearch=(ImageView)root.findViewById(R.id.imgsearch);
        imgsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Search_Here.class);
                startActivity(intent);
            }
        });
        Address=root.findViewById(R.id.Address);
        Address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), MyAddress.class);
                startActivity(intent);
            }
        });




        imgpro=root.findViewById(R.id.imgpro);
        imgpro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), AddNewAddress.class);
                startActivity(intent);
            }
        });

        address_id=root.findViewById(R.id.address_id);
        address_id.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),MyAddress.class);
                startActivity(intent);


            }
        });

        bannerTopBottom();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    public void Categories(){

        List<CategoryResponse> modResponse = new ArrayList<CategoryResponse>();
        ApiRequest apiRequest = RetrofitRequest.getRetrofit().create(ApiRequest.class);
        Call<CategoryResponse> call = apiRequest.getCategory( "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.IjIi.JfakD98H1B3RWE6yG4gdaaVlkHhwQr5SdpuXQ23n_4U");
        call.enqueue(new Callback<CategoryResponse>() {

            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {

                Toast.makeText(getContext(), "onResponse---------------------", Toast.LENGTH_SHORT).show();
                Log.e("MainActivity ", "onResponse----------------");
                Log.e("MainActivity", "onResponse----------------"+response.body().getData().toString());
                Log.e("MainActivity", "onResponse----------------"+response.body().getData().get(1).getName());
                Log.e("MainActivity", "onResponse----------------"+response.body().getData().get(0).getImage());

                CategoryResponse response1 = response.body();
                if (response.body().getData().size() >= 0){

                    for(int i=0;i<response.body().getData().size();i++){

                        modResponse.add(response1);
                        Log.e("HomeFragment", "for loop condition in true");

                   // Log.e("HomeFragment", "onResponse"+response.body().getData().get(i));
                        Log.e("HomeFragment", "onResponse" + response.body().getData().get(i).toString());
                    }

                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    CategoryAdapter adapter = new CategoryAdapter(modResponse,getContext());
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

                }
                else {

                    Log.e("HomeFragment", "for loop condition is false ----------------"+response.body().getData().size());

                }

            }




            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {

                Log.e("MainActivity", "dfhAFHKJHAKH----------"+t.getMessage());

            }
        });




    }

public void bannerTopBottom(){

        Log.e("MainActivity", "bannerTop-----------------");
    List<BannerTopBottomResponse> bannerTop = new ArrayList<>();
    List<BannerBottomModel> bannerBottom = new ArrayList<>();

    ApiRequest apiRequest = RetrofitRequest.getRetrofit().create(ApiRequest.class);
   Call<BannerTopBottomResponse> call = apiRequest.BannerSlider("158|pI9sURZYCbzICubIOxJgvfezQuz9WxhiNyo9rpAn");
   call.enqueue(new Callback<BannerTopBottomResponse>() {
    @Override
    public void onResponse(Call<BannerTopBottomResponse> call, Response<BannerTopBottomResponse> response) {

        Log.e("HomeActivity", "onResponse:-----BannerSlider----" + response.body());

        BannerTopBottomResponse response1= response.body();



     }


    @Override
    public void onFailure(Call<BannerTopBottomResponse> call, Throwable t) {



    }
    });







}





}