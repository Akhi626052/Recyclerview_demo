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

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.MainVH>{

    List<CardModel> CardModel;
    Context context;

    public CardAdapter(List<com.daizzyinfo.recyclerview_demo.CardModel> cardModel, Context context) {
        CardModel = cardModel;
        this.context = context;
    }

    @NonNull
    @Override
    public MainVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cheese_corn_sandwig,parent,false);
        return new CardAdapter.MainVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardAdapter.MainVH holder, int position) {
        holder.cheeseCor.setText(CardModel.get(position).getCheeseCor());
        holder.imgfood.setImageResource(CardModel.get(position).getImgfood());
    }

    @Override
    public int getItemCount() {
        return CardModel.size();
    }

    public class MainVH extends RecyclerView.ViewHolder {

        ImageView imgfood;
        TextView cheeseCor;

        public MainVH(@NonNull View itemView) {
            super(itemView);
            imgfood=itemView.findViewById(R.id.imgfood);
            cheeseCor=itemView.findViewById(R.id.cheeseCor);

        }
    }
}

