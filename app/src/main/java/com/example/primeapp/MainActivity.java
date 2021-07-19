package com.example.primeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import com.example.primeapp.adapter.BannerMoviesPagerAdapter;
import com.example.primeapp.adapter.MainRecyclerAdapter;
import com.example.primeapp.model.AllCategory;
import com.example.primeapp.model.BannerMovies;
import com.example.primeapp.model.CategoryItem;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    BannerMoviesPagerAdapter bannerMoviesPagerAdapter;
    TabLayout indicatorTab, categoryTab;
    ViewPager bannerMoviesViewPager;
    List<BannerMovies> homebannerList;
    List<BannerMovies> tvShowbannerList;
    List<BannerMovies> moviebannerList;
    List<BannerMovies> kidsbannerList;
    MainRecyclerAdapter mainRecyclerAdapter;
   // Toolbar toolbar;
    RecyclerView mainRecycler;
    List<AllCategory> allCategoryList;
    NestedScrollView nestedScrollView;
    AppBarLayout appBarLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();





        indicatorTab = findViewById(R.id.tab_indicator);
        categoryTab = findViewById(R.id.tablayout);
        nestedScrollView = findViewById(R.id.nested_scroll);
        appBarLayout = findViewById(R.id.appbar);

       // toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //Add dummy data
        homebannerList = new ArrayList<>();
        homebannerList.add(new BannerMovies(R.drawable.radhe, "moviename","https://storage.googleapis.com/gvabox/media/samples/stock.mp4"));
        homebannerList.add(new BannerMovies(R.drawable.moana, "Moana","https://www.zee5.com/movies/details/watch-uri-the-surgical-strike-full-movie-online/0-0-33204"));
        homebannerList.add(new BannerMovies(R.drawable.bajrangibhaijaan, "Bajrangibhaijaan","https://www.zee5.com/movies/details/watch-uri-the-surgical-strike-full-movie-online/0-0-33204"));
        homebannerList.add(new BannerMovies(R.drawable.cindrella, "cindrella","https://www.zee5.com/movies/details/watch-uri-the-surgical-strike-full-movie-online/0-0-33204"));
        homebannerList.add(new BannerMovies(R.drawable.ironman, "ironman","https://www.zee5.com/movies/details/watch-uri-the-surgical-strike-full-movie-online/0-0-33204"));


        tvShowbannerList = new ArrayList<>();
        tvShowbannerList.add(new BannerMovies(R.drawable.uri, "URI","https://www.zee5.com/movies/details/watch-uri-the-surgical-strike-full-movie-online/0-0-33204"));
        tvShowbannerList.add(new BannerMovies(R.drawable.moana, "Moana","https://www.zee5.com/movies/details/watch-uri-the-surgical-strike-full-movie-online/0-0-33204"));
        tvShowbannerList.add(new BannerMovies(R.drawable.bajrangibhaijaan, "Bajrangibhaijaan","https://www.zee5.com/movies/details/watch-uri-the-surgical-strike-full-movie-online/0-0-33204"));
        tvShowbannerList.add(new BannerMovies(R.drawable.cindrella, "cindrella","https://www.zee5.com/movies/details/watch-uri-the-surgical-strike-full-movie-online/0-0-33204"));
        tvShowbannerList.add(new BannerMovies(R.drawable.ironman, "ironman","https://www.zee5.com/movies/details/watch-uri-the-surgical-strike-full-movie-online/0-0-33204"));


        moviebannerList = new ArrayList<>();
        moviebannerList.add(new BannerMovies(R.drawable.mommy, "moviename","https://www.zee5.com/movies/details/watch-uri-the-surgical-strike-full-movie-online/0-0-33204"));
        moviebannerList.add(new BannerMovies(R.drawable.moana, "Moana","https://www.zee5.com/movies/details/watch-uri-the-surgical-strike-full-movie-online/0-0-33204"));
        moviebannerList.add(new BannerMovies(R.drawable.bajrangibhaijaan, "Bajrangibhaijaan","https://www.zee5.com/movies/details/watch-uri-the-surgical-strike-full-movie-online/0-0-33204"));
        moviebannerList.add(new BannerMovies(R.drawable.cindrella, "cindrella","https://www.zee5.com/movies/details/watch-uri-the-surgical-strike-full-movie-online/0-0-33204"));
        moviebannerList.add(new BannerMovies(R.drawable.ironman, "ironman","https://www.zee5.com/movies/details/watch-uri-the-surgical-strike-full-movie-online/0-0-33204"));


        kidsbannerList = new ArrayList<>();
        kidsbannerList.add(new BannerMovies(R.drawable.radhe, "moviename","https://www.zee5.com/movies/details/watch-uri-the-surgical-strike-full-movie-online/0-0-33204"));
        kidsbannerList.add(new BannerMovies(R.drawable.moana, "Moana","https://www.zee5.com/movies/details/watch-uri-the-surgical-strike-full-movie-online/0-0-33204"));
        kidsbannerList.add(new BannerMovies(R.drawable.bajrangibhaijaan, "Bajrangibhaijaan","https://www.zee5.com/movies/details/watch-uri-the-surgical-strike-full-movie-online/0-0-33204"));
        kidsbannerList.add(new BannerMovies(R.drawable.cindrella, "cindrella","https://www.zee5.com/movies/details/watch-uri-the-surgical-strike-full-movie-online/0-0-33204"));
        kidsbannerList.add(new BannerMovies(R.drawable.ironman, "ironman","https://www.zee5.com/movies/details/watch-uri-the-surgical-strike-full-movie-online/0-0-33204"));

//this is default tab selected
        setBannerMoviesPagerAdapter(homebannerList);
        //https://en.wikipedia.org/wiki/File:Radhe_film_poster.jpg#/media/File:Radhe_film_poster.jpg
        //on tab change selected data
        categoryTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 1:
                        setScrollDefaultState();
                        setBannerMoviesPagerAdapter(tvShowbannerList);
                        return;
                    case 2:
                        setScrollDefaultState();
                        setBannerMoviesPagerAdapter(moviebannerList);
                        return;
                    case 3:
                        setScrollDefaultState();
                        setBannerMoviesPagerAdapter(kidsbannerList);
                        return;
                    default:
                        setScrollDefaultState();
                        setBannerMoviesPagerAdapter(homebannerList);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        List<CategoryItem> homrCatListItem1 = new ArrayList<>();
        homrCatListItem1.add(new CategoryItem(R.drawable.uri,"URI","https://www.zee5.com/movies/details/watch-uri-the-surgical-strike-full-movie-online/0-0-33204"));
        homrCatListItem1.add(new CategoryItem(R.drawable.moana,"moana","https://www.zee5.com/movies/details/watch-uri-the-surgical-strike-full-movie-online/0-0-33204"));
        homrCatListItem1.add(new CategoryItem(R.drawable.radhe,"Radhe","https://www.zee5.com/movies/details/watch-uri-the-surgical-strike-full-movie-online/0-0-33204"));
        homrCatListItem1.add(new CategoryItem(R.drawable.bajrangibhaijaan,"bajrangibhaijaan","https://www.zee5.com/movies/details/watch-uri-the-surgical-strike-full-movie-online/0-0-33204"));
        homrCatListItem1.add(new CategoryItem(R.drawable.cindrella,"cindrella","https://www.zee5.com/movies/details/watch-uri-the-surgical-strike-full-movie-online/0-0-33204"));

        List<CategoryItem> homrCatListItem2 = new ArrayList<>();
        homrCatListItem2.add(new CategoryItem(R.drawable.mommy,"MOMMY","https://www.zee5.com/movies/details/watch-uri-the-surgical-strike-full-movie-online/0-0-33204"));
        homrCatListItem2.add(new CategoryItem(R.drawable.radhe,"moana","https://www.zee5.com/movies/details/watch-uri-the-surgical-strike-full-movie-online/0-0-33204"));
        homrCatListItem2.add(new CategoryItem(R.drawable.moana,"Radhe","https://www.zee5.com/movies/details/watch-uri-the-surgical-strike-full-movie-online/0-0-33204"));
        homrCatListItem2.add(new CategoryItem(R.drawable.bajrangibhaijaan,"bajrangibhaijaan","https://www.zee5.com/movies/details/watch-uri-the-surgical-strike-full-movie-online/0-0-33204"));
        homrCatListItem2.add(new CategoryItem(R.drawable.cindrella,"cindrella","https://www.zee5.com/movies/details/watch-uri-the-surgical-strike-full-movie-online/0-0-33204"));

        List<CategoryItem> homrCatListItem3 = new ArrayList<>();
        homrCatListItem3.add(new CategoryItem(R.drawable.ironman,"ironman","https://www.zee5.com/movies/details/watch-uri-the-surgical-strike-full-movie-online/0-0-33204"));
        homrCatListItem3.add(new CategoryItem(R.drawable.moana,"moana","https://www.zee5.com/movies/details/watch-uri-the-surgical-strike-full-movie-online/0-0-33204"));
        homrCatListItem3.add(new CategoryItem(R.drawable.radhe,"Radhe",""));
        homrCatListItem3.add(new CategoryItem(R.drawable.bajrangibhaijaan,"bajrangibhaijaan","https://www.zee5.com/movies/details/watch-uri-the-surgical-strike-full-movie-online/0-0-33204"));
        homrCatListItem3.add(new CategoryItem(R.drawable.cindrella,"cindrella","https://www.zee5.com/movies/details/watch-uri-the-surgical-strike-full-movie-online/0-0-33204"));



        allCategoryList = new ArrayList<>();
        allCategoryList.add(new AllCategory(1,"Bollywood","",homrCatListItem1));
        allCategoryList.add(new AllCategory(2,"hollywood","",homrCatListItem2));
        allCategoryList.add(new AllCategory(3,"kids","",homrCatListItem3));
        //here we pass array to recycler setup method
        setMainRecycler(allCategoryList);


    }

    private void setBannerMoviesPagerAdapter(List<BannerMovies> bannerMoviesList) {
        bannerMoviesViewPager = findViewById(R.id.banner_Viewpager);
        bannerMoviesPagerAdapter = new BannerMoviesPagerAdapter(this, bannerMoviesList);
        bannerMoviesViewPager.setAdapter(bannerMoviesPagerAdapter);
        indicatorTab.setupWithViewPager(bannerMoviesViewPager);
        //fix time for auto slider
        Timer sliderTimer = new Timer();
        sliderTimer.scheduleAtFixedRate(new AutoSlider(), 5000, 7000);
        indicatorTab.setupWithViewPager(bannerMoviesViewPager, true);


    }

    //AutoSlider code
    class AutoSlider extends TimerTask {


        @Override
        public void run() {
            MainActivity.this.runOnUiThread(this::run2);
        }

        private void run2() {
            if (bannerMoviesViewPager.getCurrentItem() < homebannerList.size() - 1) {

                bannerMoviesViewPager.setCurrentItem(bannerMoviesViewPager.getCurrentItem() + 1);
            } else {
                bannerMoviesViewPager.setCurrentItem(0);

            }
        }
    }

    //setting up virtical recyclarview with category title

    public void setMainRecycler(List<AllCategory> allCategoryList) {
        mainRecycler = findViewById(R.id.main_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        mainRecycler.setLayoutManager(layoutManager);
        mainRecyclerAdapter = new MainRecyclerAdapter(this,allCategoryList);
        mainRecycler.setAdapter(mainRecyclerAdapter);

    }
    private void setScrollDefaultState(){
        nestedScrollView.fullScroll(View.FOCUS_UP);
        nestedScrollView.scrollTo(0,0);
        appBarLayout.setExpanded(true);
    }

}
