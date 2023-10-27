package com.daizzyinfo.recyclerview_demo.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.daizzyinfo.recyclerview_demo.CardAdapter;
import com.daizzyinfo.recyclerview_demo.CardModel;
import com.daizzyinfo.recyclerview_demo.R;
import com.daizzyinfo.recyclerview_demo.databinding.FragmentDashboardBinding;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    RecyclerView recyclerView;
    List<CardModel> models=new ArrayList<>();





    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashBoardModel dashboardViewModel =
                new ViewModelProvider(this).get(DashBoardModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        recyclerView=root.findViewById(R.id.recyclerView);

        models.add(new CardModel(R.drawable.food_image2, "dkfjklsa"));
        models.add(new CardModel(R.drawable.food_image2,"dkjlfk"));
        models.add(new CardModel(R.drawable.food_image2, "dkfjklsa"));
        models.add(new CardModel(R.drawable.food_image2,"dkjlfk"));
        models.add(new CardModel(R.drawable.food_image2, "dkfjklsa"));
        models.add(new CardModel(R.drawable.food_image2,"dkjlfk"));

        CardAdapter Adapter = new CardAdapter(models,getContext());
        LinearLayoutManager manager= new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(Adapter);








//        final TextView textView = binding.textDashboard;
//        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}