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
import com.example.ecommerce.models.ItemModel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

public class ProdactAdapter extends RecyclerView.Adapter<ProdactAdapter.ViewHolder>{

    Context context ;
    List<ItemModel> items ;
    onProdactDetailsListner onProdactDetailsListner ;

    public ProdactAdapter(Context context , List<ItemModel> items , onProdactDetailsListner onProdactDetailsListner) {
        this.context = context ;
        this.items = items;
        this.onProdactDetailsListner = onProdactDetailsListner;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.prodact_card , parent ,false) ;
        return new ViewHolder(view , this.onProdactDetailsListner);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        // do some animation

        holder.linearLayout.setAnimation(AnimationUtils.loadAnimation(context ,R.anim.fade_scale_animation));

        ItemModel currentItem = items.get(position);
        holder.image.setImageResource(currentItem.getItemImage());
        holder.type.setText(currentItem.getItemType());
        holder.title.setText(currentItem.getItemTitle());
        holder.price.setText( currentItem.getItemPrice());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title , type , price  ;
        ImageView image ;
        LinearLayout linearLayout;
        onProdactDetailsListner onProdactDetailsListner ;

        public ViewHolder(@NonNull View itemView ,  onProdactDetailsListner onProdactDetailsListner ) {
            super(itemView);

            linearLayout = itemView.findViewById(R.id.prodact_card_parent);
            title = itemView.findViewById(R.id.prodact_name) ;
            image = itemView.findViewById(R.id.prodact_iamge);
            type = itemView.findViewById(R.id.prodact_type);
            price = itemView.findViewById(R.id.prodact_price);
            this.onProdactDetailsListner = onProdactDetailsListner ;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onProdactDetailsListner.onProdactDetailsClick(getAdapterPosition());
        }
    }
    public interface onProdactDetailsListner {

        void onProdactDetailsClick(int position) ;
    }
}
