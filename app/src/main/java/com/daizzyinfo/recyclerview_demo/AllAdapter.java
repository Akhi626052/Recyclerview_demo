package com.daizzyinfo.recyclerview_demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

public class AllAdapter extends RecyclerView.Adapter<AllAdapter.ItemVH>{

    List<AllModel> AllModel;

   Context context;

    public AllAdapter(List<com.daizzyinfo.recyclerview_demo.AllModel> allModel, Context context) {
        AllModel = allModel;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.all_items,parent,false);
        return new ItemVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemVH holder, int position) {
    holder.imagesrc3.setImageResource(AllModel.get(position).getImagesrc3());
    holder.txtName3.setText(AllModel.get(position).getTxtName3());
    }

    @Override
    public int getItemCount() {
        return AllModel.size();
    }

    public class ItemVH extends RecyclerView.ViewHolder {
        ShapeableImageView imagesrc3;
        TextView txtName3;

        public ItemVH(@NonNull View itemView) {
            super(itemView);
            imagesrc3 = itemView.findViewById(R.id.imagesrc3);
            txtName3 = itemView.findViewById((R.id.txtName3));
        }
    }
}
