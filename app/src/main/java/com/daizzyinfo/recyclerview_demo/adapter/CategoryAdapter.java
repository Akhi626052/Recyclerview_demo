package com.daizzyinfo.recyclerview_demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.daizzyinfo.recyclerview_demo.R;
import com.daizzyinfo.recyclerview_demo.response.CategoryResponse;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.categoryVH> {

    String url = "https://test-daizzyinfosys.com/food/api/category/";

    List<CategoryResponse> categResoponse ;
    Context context;

    public CategoryAdapter(List<CategoryResponse> categResoponse, Context context) {
        this.categResoponse = categResoponse;
        this.context = context;
    }

    @NonNull
    @Override
    public categoryVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

  //  View view = LayoutInflater.from(context).inflate(R.layout.category_items,parent,false);

        View view = LayoutInflater.from(context).inflate(R.layout.category_items, parent,false);
        return new categoryVH(view);

    }

    @Override
    public void onBindViewHolder(@NonNull categoryVH holder, int position) {
      holder.TxtFoodName.setText(categResoponse.get(position).getData().get(position).getName());

        Glide
                .with(context)
                .load(categResoponse.get(position).getData().get(position).getImage())
               // .error(R.drawable.ic_launcher_foreground)
                .placeholder(R.drawable.food)
                .override(100,100)
                .into(holder.image_id);


 //   holder.TxtFoodName.setText(categoryResponses.get(position).getName());
  //  holder.ImgFood.setImageResource(categoryResponses.get(position).getFoodImage());
    }

    @Override
    public int getItemCount() {

        return categResoponse.size();

    }

    public class categoryVH extends RecyclerView.ViewHolder{
        ImageView image_id;
        TextView TxtFoodName;

        public categoryVH(@NonNull View itemView) {
            super(itemView);

            image_id= itemView.findViewById(R.id.image_id);
            TxtFoodName = itemView.findViewById(R.id.TxtFoodName);

        }
    }
}
