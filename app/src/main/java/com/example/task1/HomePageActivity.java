package com.example.task1;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task1.api.MovieApiService;
import com.example.task1.api.RetrofitClient;
import com.example.task1.model.Movie;
import com.example.task1.model.MovieResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePageActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private com.example.task1.MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2)); // 2 columns

        movieAdapter = new com.example.task1.MovieAdapter(new ArrayList<>());
        recyclerView.setAdapter(movieAdapter);

        fetchMovies();
    }

    private void fetchMovies() {
        MovieApiService apiService = RetrofitClient.getInstance().create(MovieApiService.class);
        String apiKey = getString(R.string.tmdb_api_key);

        Call<MovieResponse> call = apiService.getPopularMovies(apiKey);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Movie> movieList = response.body().getResults();
                    if (movieList != null && !movieList.isEmpty()) {
                        movieAdapter.updateMovies(movieList);
                    } else {
                        Toast.makeText(HomePageActivity.this, "No movies found", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(HomePageActivity.this, "Failed to load movies", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Toast.makeText(HomePageActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("HomePageActivity", "onFailure: ", t);
            }
        });
    }
}
