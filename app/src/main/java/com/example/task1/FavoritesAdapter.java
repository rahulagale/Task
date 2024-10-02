package com.example.task1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.FavoritesViewHolder> {
    private List<FavoriteMovie> favoriteMovies;
    private Context context;

    public FavoritesAdapter(List<FavoriteMovie> favoriteMovies, Context context) {
        this.favoriteMovies = favoriteMovies;
        this.context = context;
    }

    @NonNull
    @Override
    public FavoritesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorite_movie_item, parent, false);
        return new FavoritesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritesViewHolder holder, int position) {
        FavoriteMovie favoriteMovie = favoriteMovies.get(position);
        holder.titleTextView.setText(favoriteMovie.getTitle());

        String imageUrl = "https://image.tmdb.org/t/p/w500" + favoriteMovie.getPosterPath();
        Glide.with(context)
                .load(imageUrl)
                .into(holder.posterImageView);
    }

    @Override
    public int getItemCount() {
        return favoriteMovies.size();
    }

    public static class FavoritesViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;
        public ImageView posterImageView;

        public FavoritesViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            posterImageView = itemView.findViewById(R.id.posterImageView);
        }
    }
}
