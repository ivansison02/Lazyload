package mgi.ivan_sison.lazyloadcache.controller.app;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import mgi.ivan_sison.lazyloadcache.model.Movie;

/**
 * Created by MGI-Ivan on 08/01/2018.
 */

public class MyApp extends Application {

    ArrayList<Movie> movies = new ArrayList();

    public void setMovie(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getMovies() {
        return movies;
    }
}