package com.example.primeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MovieDetails extends AppCompatActivity {
    ImageView movieImage;
    TextView movieName;
    Button playButton;
    String mName,mFileUrl;
    Integer mImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        getSupportActionBar().hide();

        movieImage = findViewById(R.id.movie_image);
        movieName = findViewById(R.id.movie_name);
        playButton = findViewById(R.id.play_button);

        //get data from intent
        mImage= getIntent().getIntExtra("image",1);
        mName= getIntent().getStringExtra("MovieName");
        mFileUrl= getIntent().getStringExtra("MovieUrl");
        //set data to layout
        Glide.with(this).load(mImage).into(movieImage);
        movieName.setText(mName);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MovieDetails.this,VideoPlayerActivity.class);
                intent.putExtra("url",mFileUrl);
                startActivity(intent);
            }
        });




    }
}