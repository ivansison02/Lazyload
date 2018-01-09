package mgi.ivan_sison.lazyloadcache.controller.loader;

import android.util.Log;

/**
 * Created by MGI-Ivan on 08/01/2018.
 */

public class LazyLoader {

    private int page = 0;
    private int maxItem = 5;

    private int totalItemCount;
    private int lastVisibleItem;
    private int visibleThreshold = 1;

    private boolean isLoading = false;

    public LazyLoader() {

    }

    public void addPage() {
        page += maxItem;
    }

    public void subPage() {
        page -= maxItem;
    }

    public void resetPage() {
        page = 0;
    }

    public void nextPage() {
        addPage();
    }

    public void prevPage() {
        subPage();
    }

    public int getPage() {
        return page;
    }

    public int getMaxItem() {
        return maxItem;
    }


    public int getTotalItemCount() {
        return totalItemCount;
    }

    public void setTotalItemCount(int totalItemCount) {
        this.totalItemCount = totalItemCount;
    }

    public int getLastVisibleItem() {
        return lastVisibleItem;
    }

    public int getVisibleThreshold() {
        return visibleThreshold;
    }

    public void setVisibleThreshold(int visibleThreshold) {
        this.visibleThreshold = visibleThreshold;
    }

    public void setLastVisibleItem(int lastVisibleItem) {
        this.lastVisibleItem = lastVisibleItem;
    }

    public boolean isLoading() {
        return isLoading;
    }

    public void setLoading(boolean loading) {
        isLoading = loading;
    }

    public boolean loadMore() {
        if (totalItemCount <= (lastVisibleItem + visibleThreshold)) {
            return true;
        }
        else {
            return false;
        }
    }
}
