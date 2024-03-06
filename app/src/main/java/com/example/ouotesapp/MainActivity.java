package com.example.ouotesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.ouotesapp.categories.CategoriesAdapter;
import com.example.ouotesapp.categories.CategoriesList;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<CategoriesList> categoriesLists  = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView categoriesRecylerView  = findViewById(R.id.categoriesRecylerView);
        categoriesRecylerView.setHasFixedSize(true);
        categoriesRecylerView.setLayoutManager(new GridLayoutManager(MainActivity.this,2));

        CategoriesList LoveCategory = new CategoriesList("Love",R.drawable.love);
        categoriesLists.add(LoveCategory);


        CategoriesList SmileyCategory = new CategoriesList("Smiley",R.drawable.smiley);
        categoriesLists.add(SmileyCategory);

        CategoriesList AttitudeCategory = new CategoriesList("Attitude",R.drawable.attitude);
        categoriesLists.add(AttitudeCategory);

        CategoriesList MotivatonalCategory = new CategoriesList("Motivatonal",R.drawable.motivatonal);
        categoriesLists.add(MotivatonalCategory);


        CategoriesList SadCategory = new CategoriesList("Sad",R.drawable.sad);
        categoriesLists.add(SadCategory);

        categoriesRecylerView.setAdapter(new CategoriesAdapter(categoriesLists,MainActivity.this));




    }
}