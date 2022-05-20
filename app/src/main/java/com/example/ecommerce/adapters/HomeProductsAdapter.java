package com.example.ecommerce.adapters;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ecommerce.R;
import com.example.ecommerce.fragments.Home;
import com.example.ecommerce.models.ItemModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class HomeProductsAdapter extends PagerAdapter {
    private List<ItemModel> itemsModel ;
    private LayoutInflater layoutInflater ;
    private Context context ;

    public HomeProductsAdapter(List<ItemModel> items ,Context context) {
        this.itemsModel = items;
//        this.layoutInflater = layoutInflater;
        this.context = context;
    }

    @Override
    public int getCount() {
        return itemsModel.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_card_activity , container , false) ;

        ImageView imageView ;
        TextView itemName , itemPrice , itemtype ;

        imageView =  view.findViewById(R.id.item_image) ;
        itemName = view.findViewById(R.id.item_title) ;
        itemPrice = view.findViewById(R.id.item_price) ;
        itemtype = view.findViewById(R.id.item_type) ;

        imageView.setImageResource(itemsModel.get(position).getItemImage());
        itemName.setText(itemsModel.get(position).getItemTitle());
        itemPrice.setText(itemsModel.get(position).getItemPrice());
        itemtype.setText(itemsModel.get(position).getItemType());

        container.addView(view , 0);
        return view ;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
