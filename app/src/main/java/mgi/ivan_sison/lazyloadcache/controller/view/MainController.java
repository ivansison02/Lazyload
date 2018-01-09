package mgi.ivan_sison.lazyloadcache.controller.view;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

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

    private MainInterface mInterface;
    private MovieController movieCtrl;
    private LazyLoader mLoader;

    public MainController(Context context, MainInterface mInterface, MovieInterface movieInterface) {
        this.mInterface = mInterface;

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
                    mInterface.onFinishedProgress();

                    setLoaderFinishedLoading();
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

    public void setLoaderTotalItemCount(LinearLayoutManager layoutManager) {
        mLoader.setTotalItemCount(layoutManager.getItemCount());
    }

    public void setLoaderLastVisibleItem(LinearLayoutManager layoutManager) {
        mLoader.setLastVisibleItem(layoutManager.findLastVisibleItemPosition());
    }

    public void setLoaderLoading() {
        mLoader.setLoading(true);
    }

    public void setLoaderFinishedLoading() {
        mLoader.setLoading(false);
    }

    public void onScrollView(LinearLayoutManager layoutManager) {
        setLoaderTotalItemCount(layoutManager);
        setLoaderLastVisibleItem(layoutManager);

        if (!mLoader.isLoading() && mLoader.loadMore()) {
            mInterface.onShowProgress();

            setLoaderLoading();
            getMoviesAddPage();
        }
    }
}
