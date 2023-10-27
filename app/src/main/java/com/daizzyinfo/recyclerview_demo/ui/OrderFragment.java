package com.daizzyinfo.recyclerview_demo.ui;

import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.daizzyinfo.recyclerview_demo.Activity_Order_Details;
import com.daizzyinfo.recyclerview_demo.R;
import com.daizzyinfo.recyclerview_demo.Rate_Us;
import com.daizzyinfo.recyclerview_demo.Track_Order;
import com.daizzyinfo.recyclerview_demo.ui.main.OrderDetailsFragment;

public class OrderFragment extends Fragment {
    TextView re_or,tr_order;
   RelativeLayout click_id;
    RelativeLayout click_id2;

    RelativeLayout click_id3;
    Button addnewaddress;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_order, container, false);

        re_or=view.findViewById(R.id.re_or);
        tr_order=view.findViewById(R.id.tr_order);
        TrackOrder();



        Feedback();

                click_id= view.findViewById(R.id.click_id);
        click_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(), Activity_Order_Details.class);
                intent.putExtra("ComingFrom","Upcoming");
                startActivity(intent);
            }
        });



        click_id2= view.findViewById(R.id.click_id2);
        click_id2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(), Activity_Order_Details.class);
                intent.putExtra("ComingFrom","Cancelled");
                startActivity(intent);
            }
        });




        click_id3= view.findViewById(R.id.click_id3);
        click_id3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(), Activity_Order_Details.class);
                intent.putExtra("ComingFrom","Success");
                startActivity(intent);
            }
        });






        return view;
    }

    public void Feedback(){
        re_or.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(), Rate_Us.class);
                startActivity(intent);

            }
        });
    }
    public void TrackOrder(){
        tr_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(), Track_Order.class);
                startActivity(intent);

            }
        });



    }


}