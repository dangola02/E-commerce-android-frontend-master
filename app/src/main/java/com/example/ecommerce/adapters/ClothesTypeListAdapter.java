package com.example.ecommerce.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ecommerce.R;
import com.example.ecommerce.models.ClothesTypeListModel;
import com.example.ecommerce.models.ItemModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ClothesTypeListAdapter  extends RecyclerView.Adapter<ClothesTypeListAdapter.ViewHolder>{

    Context context ;
    List<ClothesTypeListModel> cateType ;

    public ClothesTypeListAdapter(Context context, List<ClothesTypeListModel> cateType) {
        this.context = context;
        this.cateType = cateType;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cateigory_clothes_type , parent ,false) ;
        return new ClothesTypeListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ClothesTypeListModel currentItem = cateType.get(position);
        holder.typeName.setText(currentItem.getClothesTypeName());
    }

    @Override
    public int getItemCount() {
        return cateType.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView typeName ;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            typeName = itemView.findViewById(R.id.clothes_type_title);
        }
    }


}
