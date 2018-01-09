package mgi.ivan_sison.lazyloadcache.controller.loader;

/**
 * Created by MGI-Ivan on 08/01/2018.
 */

public class LazyLoader {

    private int page = 0;
    private int maxItem = 5;

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
}
