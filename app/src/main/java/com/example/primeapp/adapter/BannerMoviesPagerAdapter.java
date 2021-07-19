package com.example.primeapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.primeapp.MovieDetails;
import com.example.primeapp.R;
import com.example.primeapp.model.BannerMovies;

import java.util.List;

public class BannerMoviesPagerAdapter extends PagerAdapter {

    Context context;
    List<BannerMovies> bannerMoviesList;

    public BannerMoviesPagerAdapter(Context context, List<BannerMovies> bannerMoviesList) {
        this.context = context;
        this.bannerMoviesList = bannerMoviesList;
    }

    @Override
    public int getCount() {
        return bannerMoviesList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull  View view, @NonNull  Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(@NonNull  ViewGroup container, int position, @NonNull  Object object) {
       container.removeView((View) object);
    }

    @NonNull

    @Override
    public Object instantiateItem(@NonNull  ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.banner_movie_layout,null);
        ImageView bannerImage = view.findViewById(R.id.banner_image);
        //glide

        Glide.with(context).load(bannerMoviesList.get(position).getImage()).into(bannerImage);
        container.addView(view);
        bannerImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(context, ""+bannerMoviesList.get(position).getMovieName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, MovieDetails.class);
                intent.putExtra("image",bannerMoviesList.get(position).getImage());
                intent.putExtra("MovieName",bannerMoviesList.get(position).getMovieName());
                intent.putExtra("MovieUrl",bannerMoviesList.get(position).getFileUrl());
                context.startActivity(intent);
            }
        });
        return view;

    }
}
