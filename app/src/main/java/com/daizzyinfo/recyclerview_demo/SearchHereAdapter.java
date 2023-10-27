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

public class SearchHereAdapter extends RecyclerView.Adapter<SearchHereAdapter.HereVH> {

List<SearchHereModel> SearchHereModel;
Context context;

    public SearchHereAdapter(List<com.daizzyinfo.recyclerview_demo.SearchHereModel> searchHereModel, Context context) {
        SearchHereModel = searchHereModel;
        this.context = context;
    }

    @NonNull
    @Override
    public SearchHereAdapter.HereVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.search_here,parent,false);
    return new SearchHereAdapter.HereVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchHereAdapter.HereVH holder, int position) {
    holder.imgFood18.setImageResource(SearchHereModel.get(position).getImgFood());
    holder.textTextView11.setText(SearchHereModel.get(position).getTextTextView1());
    }

    @Override
    public int getItemCount() {

        return SearchHereModel.size();

    }

    public class HereVH extends RecyclerView.ViewHolder {

       ShapeableImageView imgFood18;
        TextView textTextView11;
        public HereVH(@NonNull View itemView) {
            super(itemView);
            imgFood18=itemView.findViewById(R.id.imgFood18);
            textTextView11=itemView.findViewById(R.id.textTextView11);

        }
    }
}
