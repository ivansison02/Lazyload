package mgi.ivan_sison.lazyloadcache.controller.view;

import android.content.Context;
import android.os.Handler;

import mgi.ivan_sison.lazyloadcache.controller.app.MyApp;
import mgi.ivan_sison.lazyloadcache.controller.loader.LazyLoader;
import mgi.ivan_sison.lazyloadcache.controller.movie.MovieController;
import mgi.ivan_sison.lazyloadcache.controller.movie.MovieInterface;

/**
 * Created by MGI-Ivan on 08/01/2018.
 */

public class MainController {

    private static final String TAG = "MainController";
    private MyApp mApp;
    private MovieController movieCtrl;
    private LazyLoader mLoader;

    public MainController(Context context, MovieInterface movieInterface) {
        mApp = (MyApp) context.getApplicationContext();

        movieCtrl = new MovieController(mApp, movieInterface);
        mLoader = new LazyLoader();
    }

    public MyApp getApp() {
        return mApp;
    }

    public void getMoviesPerPage() {
        movieCtrl.getRequestedDataPerPage(mLoader.getPage(), mLoader.getMaxItem());
    }

    public void getMoviesAddPage() {
        if (!allDataLoaded()) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mLoader.addPage();
                    movieCtrl.getRequestedDataPerPage(mLoader.getPage(), mLoader.getMaxItem());
                }
            }, 5000);
        }
        else {
            movieCtrl.allItemsLoadedByPage();
        }
    }

    public void getMoviesSubPage() {
        mLoader.subPage();

        movieCtrl.getRequestedDataPerPage(mLoader.getPage(), mLoader.getMaxItem());
    }

    public boolean allDataLoaded() {
        if (movieCtrl.retrievedAll(mLoader.getPage())) {
            return true;
        }
        else {
            return false;
        }
    }
}
