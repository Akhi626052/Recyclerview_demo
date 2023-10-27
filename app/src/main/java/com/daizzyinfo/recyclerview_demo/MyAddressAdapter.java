package com.daizzyinfo.recyclerview_demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class MyAddressAdapter extends RecyclerView.Adapter<MyAddressAdapter.AddressVH> {

    List<MyAddressModel> MyAddressModel;
    Context context;

    public MyAddressAdapter(List<com.daizzyinfo.recyclerview_demo.MyAddressModel> myAddressModel, Context context) {
        MyAddressModel = myAddressModel;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAddressAdapter.AddressVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.my_addreses,parent,false);
        return new MyAddressAdapter.AddressVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAddressAdapter.AddressVH holder, int position) {
        holder.comadd.setText(MyAddressModel.get(position).getComadd());
        holder.addcompany.setText(MyAddressModel.get(position).getAddcompany());

    }

    @Override
    public int getItemCount() {
        return MyAddressModel.size();
    }

    public class AddressVH extends RecyclerView.ViewHolder{

        TextView comadd;
        TextView addcompany;

        public AddressVH(@NonNull View itemView) {
            super(itemView);
            comadd=itemView.findViewById(R.id.comadd);
            addcompany=itemView.findViewById(R.id.addcompany);
        }
    }
}


