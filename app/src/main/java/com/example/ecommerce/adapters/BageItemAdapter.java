package com.example.ecommerce.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ecommerce.R;
import com.example.ecommerce.models.CateigoriesModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BageItemAdapter extends RecyclerView.Adapter<BageItemAdapter.ViewHolder>{
    Context context;
    List<CateigoriesModel> cateigoriesList;
    BageItemAdapter.onCateigoryListner onCateigoryListner ;

    public BageItemAdapter(Context context, List<CateigoriesModel> productCategoryList ,  BageItemAdapter.onCateigoryListner onCateigoryListner ) {
        this.context = context;
        this.cateigoriesList = productCategoryList;
        this.onCateigoryListner = onCateigoryListner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.bag_card_layout ,parent ,false) ;

        return new ViewHolder(view , onCateigoryListner);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.linearLayout.setAnimation(AnimationUtils.loadAnimation(context ,R.anim.fade_scale_animation));
        holder.cateTitle.setText(cateigoriesList.get(position).getCategoryTitle());
        holder.cateImg.setImageResource(cateigoriesList.get(position).getCategoryImg());
    }


    @Override
    public int getItemCount() {
        return cateigoriesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView cateTitle ;
        ImageView cateImg ;
        LinearLayout linearLayout ;
        BageItemAdapter.onCateigoryListner onCateigoryListner ;
        public ViewHolder(@NonNull View itemView , BageItemAdapter.onCateigoryListner onCateigoryListner ) {
            super(itemView);


            linearLayout = itemView.findViewById(R.id.bage_card_parent) ;
            cateTitle = itemView.findViewById(R.id.bage_item_title);
            cateImg = itemView.findViewById(R.id.bage_item_image);
            this.onCateigoryListner = onCateigoryListner ;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onCateigoryListner.onCategoryClick(getAdapterPosition());
        }
    }
    public interface onCateigoryListner {

        void onCategoryClick(int position) ;
    }
}
