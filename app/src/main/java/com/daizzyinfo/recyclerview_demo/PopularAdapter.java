package com.daizzyinfo.recyclerview_demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.PopularVH> {

    List<PopulerModel> popularModels;
    Context context;

    public PopularAdapter(List<PopulerModel> popularModels, Context context) {

        this.popularModels = popularModels;
        this.context = context;


    }


    @NonNull
    @Override
    public PopularAdapter.PopularVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.popular_now,parent,false);
        return new PopularAdapter.PopularVH(view);


    }

    @Override
    public void onBindViewHolder(@NonNull PopularAdapter.PopularVH holder, int position) {

        holder.textView.setText(popularModels.get(position).getImageView());
        holder.imageView.setImageResource(popularModels.get(position).getTextView());


    }

    @Override
    public int getItemCount() {
        {
            return popularModels.size();
        }

    }

    class PopularVH extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public PopularVH(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);

        }
    }

}
