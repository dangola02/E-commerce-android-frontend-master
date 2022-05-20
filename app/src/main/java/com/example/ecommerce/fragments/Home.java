package com.example.ecommerce.fragments;

import android.animation.ArgbEvaluator;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ecommerce.adapters.HomeProductsAdapter;
import com.example.ecommerce.adapters.ProdactAdapter;
import com.example.ecommerce.models.ItemModel;
import com.example.ecommerce.adapters.ItemsAdapter;
import com.example.ecommerce.R;

import java.util.ArrayList;
import java.util.List;


public class Home extends Fragment implements ItemsAdapter.onProdactDetailsListner {

    ViewPager viewPager ;
    HomeProductsAdapter homeProductsAdapter ;
    List<ItemModel> itemModels ;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    Integer[] colors = null ;
    public Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        itemModels = new ArrayList<>();
        itemModels.add(new ItemModel(1, R.drawable.image4, "Red Fashtion", "drass", "300"));
        itemModels.add(new ItemModel(2, R.drawable.image4, "Red Fashtion", "drass", "300"));
        itemModels.add(new ItemModel(3, R.drawable.image4, "Red Fashtion", "drass", "300"));
        itemModels.add(new ItemModel(4, R.drawable.image4, "Red Fashtion", "drass", "300"));


//        homeProductsAdapter = new HomeProductsAdapter(itemModels , getActivity()  ) ;

//        viewPager = (ViewPager) view.findViewById(R.id.home_product_list) ;
//        viewPager.setAdapter(homeProductsAdapter);
//        viewPager.setPadding(130 , 0 ,  130 , 0);

//        Integer [] colors_temp = {
//                getResources().getColor(R.color.black_overlay) ,
//                getResources().getColor(R.color.design_default_color_error) ,
//                getResources().getColor(R.color.design_default_color_secondary) ,
//                getResources().getColor(R.color.design_default_color_secondary_variant) ,
//        } ;
//        colors = colors_temp ;
//
//        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                if(position < (homeProductsAdapter.getCount() -1 ) && position < (colors.length -1)){
//                    viewPager.setBackgroundColor((Integer) argbEvaluator.evaluate(positionOffset , colors[position ] ,colors[position + 1]));
//                }
//                else {
//                    viewPager.setBackgroundColor(colors[colors.length -1 ]);
//                }
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
        // Inflate the layout for this fragment

        RecyclerView recyclerView = (RecyclerView) view
                .findViewById(R.id.items_list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                getActivity().getBaseContext() , LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        ItemsAdapter adapter = new ItemsAdapter(
                getActivity(), itemModels , this);

        recyclerView.setAdapter(adapter);

        return view;

    }

    @Override
    public void onProdactDetailsClick(int position) {

    }


//    private void setItemsRecycler(ArrayList<ItemModel> items) {
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
//        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerView.setHasFixedSize(true);
//        itemsAdapter = new ItemsAdapter(getActivity(), items);
//        recyclerView.setAdapter(itemsAdapter);
//    }
}