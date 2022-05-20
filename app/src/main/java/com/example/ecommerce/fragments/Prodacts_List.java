package com.example.ecommerce.fragments;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ecommerce.ProdactDetails;
import com.example.ecommerce.R;
import com.example.ecommerce.adapters.CateigoriesAdapter;
import com.example.ecommerce.adapters.ClothesTypeListAdapter;
import com.example.ecommerce.adapters.ProdactAdapter;
import com.example.ecommerce.models.CateigoriesModel;
import com.example.ecommerce.models.ClothesTypeListModel;
import com.example.ecommerce.models.ItemModel;

import java.util.ArrayList;
import java.util.List;

public class Prodacts_List extends Fragment  implements ProdactAdapter.onProdactDetailsListner{

    private ImageView backButton ;
    List<ItemModel> items ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_prodacts__list, container, false);
        // Fill Recycler View
         items = new ArrayList<>();

        items.add(new ItemModel(1, R.drawable.image4, "Red Fashtion", "drass", "300"));
        items.add(new ItemModel(1, R.drawable.image4, "Red Fashtion", "drass", "300"));
        items.add(new ItemModel(1, R.drawable.image3, "Red Fashtion", "drass", "300"));
        items.add(new ItemModel(1, R.drawable.image6, "Red Fashtion", "drass", "300"));
        items.add(new ItemModel(1, R.drawable.image6, "Red Fashtion", "drass", "300"));
        items.add(new ItemModel(1, R.drawable.image3, "Red Fashtion", "drass", "300"));
        items.add(new ItemModel(1, R.drawable.image2, "Red Fashtion", "drass", "300"));
        items.add(new ItemModel(1, R.drawable.image5, "Red Fashtion", "drass", "300"));

        ArrayList<ClothesTypeListModel> cateType = new ArrayList<>();
        cateType.add(new ClothesTypeListModel("Dress" , 1));
        cateType.add(new ClothesTypeListModel("Woman T-shirt" , 2));
        cateType.add(new ClothesTypeListModel("Scarf" , 3));
        cateType.add(new ClothesTypeListModel("Cabs" , 4));
        cateType.add(new ClothesTypeListModel("Pans" , 5));
        cateType.add(new ClothesTypeListModel("Hoody" , 6));
        cateType.add(new ClothesTypeListModel("Gadget" , 7));

        // This callback will only be called when MyFragment is at least Started.
//        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
//            @Override
//            public void handleOnBackPressed() {
//                backButton = view.findViewById(R.id.back) ;
//                backButton.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        getFragmentManager().beginTransaction().addToBackStack(null).commit();
//                    }
//                });
//            }
//        };
//        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);


        RecyclerView recyclerView = (RecyclerView) view
                .findViewById(R.id.prodacts_list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                getActivity().getBaseContext() ,RecyclerView.VERTICAL , false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(false);

        ProdactAdapter adapter = new ProdactAdapter(
                getActivity(), items ,  this);

        recyclerView.setAdapter(adapter);




        RecyclerView recyclerView2 = (RecyclerView) view
                .findViewById(R.id.clothes_type_list);

        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(
                getActivity().getBaseContext() ,LinearLayoutManager.HORIZONTAL , false);
        recyclerView2.setLayoutManager(linearLayoutManager2);
        recyclerView2.setHasFixedSize(true);

        ClothesTypeListAdapter adapter2 = new ClothesTypeListAdapter(
                getActivity(), cateType );

        recyclerView2.setAdapter(adapter2);

        return view;
    }

    @Override
    public void onProdactDetailsClick(int position) {
        items.get(position) ;
//        getFragmentManager().beginTransaction().replace(R.id.fregment_container , new ProdactDetails()).commit();
        Intent intent = new Intent(getActivity().getBaseContext() , ProdactDetails.class) ;
//        ActivityOptions options = ActivityOptions
//                .makeSceneTransitionAnimation(this, items.get(position).getItemImage(), "robot");
//        Image_transition

//        startActivity(intent , options.toBundle());
        startActivity(intent );
    }
}