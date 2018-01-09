package mgi.ivan_sison.lazyloadcache.controller.movie;

import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

import mgi.ivan_sison.lazyloadcache.controller.cache.CacheHandler;
import mgi.ivan_sison.lazyloadcache.controller.app.MyApp;
import mgi.ivan_sison.lazyloadcache.model.Movie;
import mgi.ivan_sison.lazyloadcache.model.MovieModel;

/**
 * Created by MGI-Ivan on 08/01/2018.
 */

public class MovieController {

    private static final String TAG = "MovieController";
    private MovieInterface mInterface;
    private MovieModel mModel;

    private CacheHandler mCache;

    private MyApp mApp;

    public MovieController(MyApp mApp, MovieInterface mInterface) {
        this.mApp = mApp;
        this.mInterface = mInterface;

        mCache = new CacheHandler();
        mModel = new MovieModel(this, mCache);

        try {
            requestData();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void requestData() throws IOException, ClassNotFoundException {
        if (mModel.hasCache(mApp)) {
            Log.e(TAG, "Getting cached data");
            mModel.setData(mModel.getCached(mApp));
        }
        else {
            Log.e(TAG, "Requesting data");
            mModel.setData();
            cacheItems();
        }
    }

    public ArrayList<Movie> getRequestedData() {
        return mModel.getData();
    }

    public void getRequestedDataPerPage(int start, int maxItem) {
        mInterface.onDataFetching();

        if (start == 0) {
            mModel.getDataPerPage(start, maxItem, true);
        }
        else {
            mModel.getDataPerPage(start, maxItem, false);
        }

        mInterface.onDataFinishedFetching();
    }

    public void cacheItems() {
        try {
            mCache.saveMovies(mApp.getApplicationContext(), mModel.getData());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void firstItemList(ArrayList list) {
        mInterface.onDataFetch(list);
    }

    public void addItem(Movie movie) {
        mInterface.onDataFetchMore(movie);
    }

    public void allItemsLoaded() {
        mInterface.onDataFetchAllLoaded();
    }

    public void allItemsLoadedByPage() {
        mInterface.onDataFinishedFetching();
    }

    public boolean retrievedAll(int start) {
        if (start >= mModel.getData().size()) {
            return true;
        }
        else {
            return false;
        }
    }
}
