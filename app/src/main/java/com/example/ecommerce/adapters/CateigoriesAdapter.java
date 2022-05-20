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

public class  CateigoriesAdapter  extends RecyclerView.Adapter<CateigoriesAdapter.CateigloiesViewHolder>{
    Context context;
    List<CateigoriesModel> cateigoriesList;
    onCateigoryListner onCateigoryListner ;

    public CateigoriesAdapter(Context context, List<CateigoriesModel> productCategoryList ,  onCateigoryListner onCateigoryListner ) {
        this.context = context;
        this.cateigoriesList = productCategoryList;
        this.onCateigoryListner = onCateigoryListner;
    }

    @NonNull
    @Override
    public CateigoriesAdapter.CateigloiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cateigory ,parent ,false) ;

        return new CateigloiesViewHolder(view , onCateigoryListner);
    }

    @Override
    public void onBindViewHolder(@NonNull CateigloiesViewHolder holder, int position) {

        holder.linearLayout.setAnimation(AnimationUtils.loadAnimation(context ,R.anim.animation_recycling));
        holder.cateTitle.setText(cateigoriesList.get(position).getCategoryTitle());
        holder.cateImg.setImageResource(cateigoriesList.get(position).getCategoryImg());

    }

    @Override
    public int getItemCount() {
        return cateigoriesList.size();
    }

    public class CateigloiesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView cateTitle ;
        ImageView cateImg ;
        onCateigoryListner onCateigoryListner ;
        LinearLayout linearLayout ;
        public CateigloiesViewHolder(@NonNull View itemView , onCateigoryListner onCateigoryListner ) {
            super(itemView);

            linearLayout = itemView.findViewById(R.id.categories_card);
            cateTitle = itemView.findViewById(R.id.categories_title);
            cateImg = itemView.findViewById(R.id.categories_img);
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
