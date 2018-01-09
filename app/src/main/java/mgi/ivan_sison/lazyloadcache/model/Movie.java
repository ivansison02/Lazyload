package mgi.ivan_sison.lazyloadcache.model;

import java.io.Serializable;

/**
 * Created by MGI-Ivan on 08/01/2018.
 */

public class Movie implements Serializable {

    private String movieName;
    private String movieImage;
    private String movieDesc;

    public Movie(String movieName, String movieImage, String movieDesc) {
        this.movieName = movieName;
        this.movieImage = movieImage;
        this.movieDesc = movieDesc;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieImage() {
        return movieImage;
    }

    public void setMovieImage(String movieImage) {
        this.movieImage = movieImage;
    }

    public String getMovieDesc() {
        return movieDesc;
    }

    public void setMovieDesc(String movieDesc) {
        this.movieDesc = movieDesc;
    }
}
