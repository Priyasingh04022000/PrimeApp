package com.example.primeapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.primeapp.MovieDetails;
import com.example.primeapp.R;
import com.example.primeapp.model.CategoryItem;

import java.util.List;

public class ItemRecyclerAdapter extends RecyclerView.Adapter<ItemRecyclerAdapter.ItemViewHolder> {

    Context context;
    List<CategoryItem> categoryItemList;

    public ItemRecyclerAdapter(Context context, List<CategoryItem> categoryItemList) {
        this.context = context;
        this.categoryItemList = categoryItemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.cat_recycler_row_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemRecyclerAdapter.ItemViewHolder holder, int position) {
        Glide.with(context).load(categoryItemList.get(position).getImage()).into(holder.itemImage);
        holder.itemImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(context, ""+categoryItemList.get(position).getMovieName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, MovieDetails.class);
                intent.putExtra("image",categoryItemList.get(position).getImage());
                intent.putExtra("MovieName",categoryItemList.get(position).getMovieName());
                intent.putExtra("MovieUrl",categoryItemList.get(position).getFileUrl());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return categoryItemList.size();
    }

    public static final class ItemViewHolder extends  RecyclerView.ViewHolder{
        ImageView itemImage;


        public ItemViewHolder(@NonNull  View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image);
        }
    }
}
