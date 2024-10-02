package com.example.task1;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "favorites")
public class FavoriteMovie {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String posterPath;

    public FavoriteMovie(String title, String posterPath) {
        this.title = title;
        this.posterPath = posterPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getPosterPath() {
        return posterPath;
    }
}
