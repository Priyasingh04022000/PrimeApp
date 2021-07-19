package com.example.primeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.multidex.MultiDex;

import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ext.ima.ImaAdsLoader;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

public class VideoPlayerActivity extends AppCompatActivity {
private PlayerView videoPlayer;
private SimpleExoPlayer simpleExoPlayer;
private static final String FILE_URL="";
    private ImaAdsLoader adsLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        getSupportActionBar().hide();

//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        MultiDex.install(this);

        videoPlayer= findViewById(R.id.exo_player);
        adsLoader = new ImaAdsLoader.Builder(/* context= */ this).build();
        setUpExoPlayer(getIntent().getStringExtra("url"));
    }

    @Override
    public void onStart() {
        super.onStart();
        //
        if (Util.SDK_INT > 23) {
            setUpExoPlayer("");
            if (videoPlayer != null) {
                videoPlayer.onResume();
            }
        }
    }
    @Override
    public void onResume() {
        super.onResume();
        if (Util.SDK_INT <= 23 || simpleExoPlayer == null) {
            setUpExoPlayer("");
            if (videoPlayer != null) {
                videoPlayer.onResume();
            }
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (Util.SDK_INT <= 23) {
            if (videoPlayer != null) {
                videoPlayer.onPause();
            }
            releasePlayer();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (Util.SDK_INT > 23) {
            if (videoPlayer != null) {
                videoPlayer.onPause();
            }
            releasePlayer();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        adsLoader.release();
    }

    private void releasePlayer() {
        adsLoader.setPlayer(null);
        videoPlayer.setPlayer(null);
        simpleExoPlayer.release();
        simpleExoPlayer = null;
    }

    private void setUpExoPlayer(String url){


        simpleExoPlayer = new SimpleExoPlayer.Builder(this).build();
        videoPlayer.setPlayer(simpleExoPlayer);
        DataSource.Factory dataSourceFactory =
                new DefaultDataSourceFactory(this, Util.getUserAgent(this, getString(R.string.app_name)));
        MediaSourceFactory mediaSourceFactory =
                new DefaultMediaSourceFactory(dataSourceFactory)
                        .setAdsLoaderProvider(unusedAdTagUri -> adsLoader)
                        .setAdViewProvider(videoPlayer);
        MediaItem mediaItem = new MediaItem.Builder().setUri(Uri.parse(url)).build();
        simpleExoPlayer.prepare();
        adsLoader.setPlayer(simpleExoPlayer);
        simpleExoPlayer.setPlayWhenReady(true);

    }
}