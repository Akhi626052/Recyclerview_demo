package com.daizzyinfo.recyclerview_demo.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.daizzyinfo.recyclerview_demo.R;

public class OrderDetailsFragment extends Fragment {


//    RelativeLayout click_id;
    private MainViewModel mViewModel;

    public static OrderDetailsFragment newInstance() {
        return new OrderDetailsFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

//        click_id= view.findViewById(R.id.click_id);
//        click_id.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent= new Intent(getActivity(), OrderDetailsFragment.class);
//                startActivity(intent);
//            }
//        });


    return view;

    }




}