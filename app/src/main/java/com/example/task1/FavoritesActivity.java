package com.example.task1;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task1.database.MovieDao;

public class FavoritesActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FavoritesAdapter favoritesAdapter;
    private MovieDao movieDao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite_movie_item);

//        recyclerView = findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        movieDao = AppDatabase.getInstance(this).movieDao();

    }
}
