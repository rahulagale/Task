package com.example.task1.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.task1.model.Movie;

import java.util.List;

@Dao
public interface MovieDao {

    @Insert
    void insertMovie(Movie movie);

    @Query("SELECT * FROM movies")
    List<Movie> getAllMovies();

    @Query("DELETE FROM movies")
    void deleteAllMovies();
}
