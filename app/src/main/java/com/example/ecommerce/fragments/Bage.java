package com.example.ecommerce.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ecommerce.R;
import com.example.ecommerce.adapters.BageItemAdapter;
import com.example.ecommerce.adapters.CateigoriesAdapter;
import com.example.ecommerce.models.CateigoriesModel;

import java.util.ArrayList;


public class Bage extends Fragment implements BageItemAdapter.onCateigoryListner {

    private ArrayList<CateigoriesModel> caties ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bage, container, false);
        caties = new ArrayList<>();
        caties.add(new CateigoriesModel(1, "Women Tshirt", R.drawable.image2));
        caties.add(new CateigoriesModel(1, "Women Tshirt", R.drawable.image6));
        caties.add(new CateigoriesModel(1, "Women Tshirt", R.drawable.image4));
        caties.add(new CateigoriesModel(1, "Women Tshirt", R.drawable.image5));



        RecyclerView recyclerView = (RecyclerView) view
                .findViewById(R.id.bage_item_list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                getActivity().getBaseContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        BageItemAdapter adapter = new BageItemAdapter(
                getActivity(), caties  , this);

        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onCategoryClick(int position) {

    }
}