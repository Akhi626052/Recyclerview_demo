package com.daizzyinfo.recyclerview_demo.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.daizzyinfo.recyclerview_demo.model.AllCategoryModel;
import com.daizzyinfo.recyclerview_demo.R;
import com.daizzyinfo.recyclerview_demo.response.AllCategoriesResponse;
import com.daizzyinfo.recyclerview_demo.response.CategoryResponse;

import java.util.ArrayList;
import java.util.List;

public class AllCategoryAdapter extends RecyclerView.Adapter<AllCategoryAdapter.MainVH> {

    List<CategoryResponse> allCategoriesResponses = new ArrayList<>();
    Context context;

    public AllCategoryAdapter(List<CategoryResponse> allCategoriesResponses, Context context) {
        this.allCategoriesResponses = allCategoriesResponses;
        this.context = context;
    }

    @NonNull
    @Override
    public AllCategoryAdapter.MainVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_categories_item,parent,false);
        return new AllCategoryAdapter.MainVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllCategoryAdapter.MainVH holder, int position) {
holder.foodname_id.setText(allCategoriesResponses.get(position).getData().get(position).getName());

        Glide.with(context)
               .load(allCategoriesResponses.get(position).getData().get(position).getImage())
                .override(100, 100)
                .placeholder(R.drawable.food2)
                .into(holder.foodimg_id);

    /*        holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context,FoodDetailsActivity.class);
                    intent.putExtra("name",allCategoriesResponses.get(position).getData().get(position).getName());
                    intent.putExtra("image",allCategoriesResponses.get(position).getData().get(position).getImage());
                    context.startActivity(intent);
                }
            });*/

    }

    @Override
    public int getItemCount() {
        return allCategoriesResponses.size();
    }

    public class MainVH extends RecyclerView.ViewHolder{

        ImageView foodimg_id;
        TextView foodname_id;

        public MainVH(@NonNull View itemView) {
            super(itemView);
            foodimg_id=itemView.findViewById(R.id.foodimg_id);
            foodname_id=itemView.findViewById(R.id.foodname_id);



        }
    }
}
