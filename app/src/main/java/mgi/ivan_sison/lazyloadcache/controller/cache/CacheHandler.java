package mgi.ivan_sison.lazyloadcache.controller.cache;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import mgi.ivan_sison.lazyloadcache.model.Movie;

/**
 * Created by MGI-Ivan on 08/01/2018.
 */

public class CacheHandler {

    private static final String TAG = "CacheHandler";

    public void saveMovies(Context context, ArrayList<Movie> movie) {
        try {
            FileOutputStream fileOutputStream = context.openFileOutput("movies.txt", Context.MODE_PRIVATE);
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
            out.writeObject(movie);
            out.close();
            fileOutputStream.close();

            Log.e(TAG, "Successful saving movies");

        } catch (IOException e) {
            Log.e(TAG, e.toString());
        }
    }

    public ArrayList<Movie> readMovies(Context context) {
        ArrayList<Movie> savedArrayList = null;

        try {
            FileInputStream inputStream = context.openFileInput("movies.txt");
            ObjectInputStream in = new ObjectInputStream(inputStream);
            savedArrayList = (ArrayList<Movie>) in.readObject();
            in.close();
            inputStream.close();

            Log.e(TAG, "Reading movies");



        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }

        return savedArrayList;
    }
}
