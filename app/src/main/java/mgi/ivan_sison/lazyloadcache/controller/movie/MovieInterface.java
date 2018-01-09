package mgi.ivan_sison.lazyloadcache.controller.movie;

import java.util.ArrayList;
import java.util.List;

import mgi.ivan_sison.lazyloadcache.model.Movie;

/**
 * Created by MGI-Ivan on 08/01/2018.
 */

public interface MovieInterface {

    void onDataFetch(ArrayList list);

    void onDataFetchMore(Movie movie);

    void onDataFetchAll(ArrayList list);

    void onDataFetchAllLoaded();

    void onDataFetching();

    void onDataFinishedFetching();

    void onFailure();
}
