package mgi.ivan_sison.lazyloadcache.model;

import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

import mgi.ivan_sison.lazyloadcache.controller.cache.CacheHandler;
import mgi.ivan_sison.lazyloadcache.controller.app.MyApp;
import mgi.ivan_sison.lazyloadcache.controller.movie.MovieController;

/**
 * Created by MGI-Ivan on 08/01/2018.
 */

public class MovieModel {

    private static final String TAG = "MovieModel";
    private ArrayList<Movie> movieList = new ArrayList();

    private MovieController mController;
    private CacheHandler mCache;

    public MovieModel(MovieController mController, CacheHandler mCache) {
        this.mController = mController;
        this.mCache = mCache;
    }

    public boolean hasCache(MyApp myApp) {
        ArrayList movies = null;

        try {
            movies = getCached(myApp);

            for (int i = 0; i < movies.size(); i++) {
                Movie movie = (Movie) movies.get(i);
                Log.e(TAG, movie.getMovieName());
            }
        }
        catch (Exception e) {
            Log.e(TAG, e.toString());
        }

        if (movies == null) {
            return false;
        }
        else {
            return true;
        }
    }

    public ArrayList getCached(MyApp myApp) throws IOException, ClassNotFoundException {
        ArrayList movies = mCache.readMovies(myApp.getApplicationContext());

        for (int i = 0; i < movies.size(); i++) {
            Movie movie = (Movie) movies.get(i);
            Log.e(TAG, movie.getMovieName());
        }

        return movies;
    }

    public void setData() {
        movieList.add(new Movie("Pacific Rim","https://upload.wikimedia.org/wikipedia/en/2/2e/Pacificrim2-poster.jpg", "Jake Pentecost is a once-promising Jaeger pilot whose legendary father gave his life to secure humanity's victory against the monstrous Kaiju. Jake has since abandoned his training only to become caught up in a criminal underworld"));
        movieList.add(new Movie("Jurassic World 2", "https://upload.wikimedia.org/wikipedia/en/c/c6/Jurassic_World_Fallen_Kingdom.png", "Four years after the destruction of the Jurassic World theme park, Owen Grady and Claire Dearing return to the island of Isla Nublar to save the remaining dinosaurs from a volcano that's about to erupt."));
        movieList.add(new Movie("Ant-Man and The Wasp", "https://upload.wikimedia.org/wikipedia/en/thumb/4/4e/Ant-Man_and_the_Wasp_logo.jpg/220px-Ant-Man_and_the_Wasp_logo.jpg", "Ant-Man joins forces with the Wasp on an urgent new mission to uncover secrets from the past."));
        movieList.add(new Movie("Post", "https://upload.wikimedia.org/wikipedia/en/0/0b/The_Post_%28film%29.png", "Katharine Graham is the first female publisher of a major American newspaper -- The Washington Post. With help from editor Ben Bradlee, Graham races to catch up with The New York Times to expose a massive cover-up of government secrets that spans three decades and four U.S. presidents."));
        movieList.add(new Movie("Fifty Shades Freed", "https://upload.wikimedia.org/wikipedia/en/b/bb/FiftyShadesFreed.jpg", ""));
        movieList.add(new Movie("Black Panther", "https://pbs.twimg.com/media/DFZHMB9XcAU5o_t.jpg", ""));
        movieList.add(new Movie("A Wrinkle in Time", "https://pbs.twimg.com/media/DO2bPZMU8AA1Q-u.jpg", ""));
        movieList.add(new Movie("Rampage", "https://pbs.twimg.com/media/DOzgA9QUEAAJCkl.jpg", ""));
        movieList.add(new Movie("Avengers: Infinity War", "https://pbs.twimg.com/media/DPxH5HUVwAAaf47.jpg", ""));
        movieList.add(new Movie("Solo: A Star Wars Story", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/46/Solo-a-star-wars-story-tall-A.png/220px-Solo-a-star-wars-story-tall-A.png", ""));
        movieList.add(new Movie("Deadpool 2", "https://upload.wikimedia.org/wikipedia/en/thumb/c/cf/Deadpool_2_poster.jpg/220px-Deadpool_2_poster.jpg", ""));
        movieList.add(new Movie("Ocean's Eight", "https://pbs.twimg.com/media/DOoSwTWXUAAxv95.jpg", ""));
        movieList.add(new Movie("All The Money In The World", "https://2.bp.blogspot.com/-Xmn70U4leMA/Wk8f1zXPbII/AAAAAAAANT8/HqiYUiAtfv8dKCLWEsoEP02J8COriPGdgCLcBGAs/s200/all%2Bmony.jpg", ""));
        movieList.add(new Movie("Ready Player One", "http://t1.gstatic.com/images?q=tbn:ANd9GcRnyXNmJKAkuclAoanfAKklvsA4Y-cDa-bTyxIZSYE7WvH6sbMU", ""));
        movieList.add(new Movie("The Incredibles 2", "https://images-na.ssl-images-amazon.com/images/M/MV5BMTYzMzc1ODM0MV5BMl5BanBnXkFtZTgwMjM5ODAyNDM@._V1_SY1000_CR0,0,674,1000_AL_.jpg", ""));
        movieList.add(new Movie("Red Sparrow", "https://upload.wikimedia.org/wikipedia/en/5/5a/Red_Sparrow.png", ""));
        movieList.add(new Movie("Isle of Dogs", "https://cdn.flickeringmyth.com/wp-content/uploads/2017/04/Isle-of-Dogs-poster.jpg", ""));
        movieList.add(new Movie("Mary Poppins", "http://img.moviepostershop.com/mary-poppins-movie-poster-1964-1020191921.jpg", ""));
        movieList.add(new Movie("Tomb Raider", "http://img.moviepostershop.com/lara-croft-tomb-raider-the-cradle-of-life-movie-poster-2003-1020216313.jpg", ""));
        movieList.add(new Movie("Venom", "https://pre00.deviantart.net/e0f8/th/pre/f/2017/189/8/d/venom_movie_poster_by_jackjack671120-dbfifrh.jpg", ""));
        movieList.add(new Movie("Aquaman", "https://dakrolak.files.wordpress.com/2016/01/jason_momoa_as_aquaman___poster__2016__by_edaba7-d9fhens.jpg", ""));
        movieList.add(new Movie("Insidious: The Last Key", "https://media.kitag.com/filer_public_thumbnails/cinepool/assets/movies/1012.074/artworks/83630460829c2a4078ac3316a1c370ef511a878d/lrg.png__650x935_q70.jpg", ""));
        movieList.add(new Movie("Predator", "http://horror.wpengine.netdna-cdn.com/wp-content/uploads/2017/09/DJnEG7IWsAIpyxr.jpg", ""));
        movieList.add(new Movie("Mission Impossible 6", "http://www.thedailymailnews.com/wp-content/uploads/2017/02/Mission-Impossible-6-Movie-Release-Date-Cast-Trailer-Ethan-Hunt-To-Appear-With-Different-Avatar-2.jpg", ""));
    }

    public void setData(ArrayList cached) {
        movieList = cached;
    }

    public ArrayList<Movie> getData() {
        return movieList;
    }

    public void getDataPerPage(int start, int maxItem, boolean first) {

        ArrayList list = new ArrayList();

        int countedItem = 0;

        for (int i = 0; i < movieList.size(); i++) {
            Movie movie = (Movie) movieList.get(i);

            if (start > movieList.size()) {

                mController.allItemsLoaded();
            }
            else if (countedItem != maxItem && i >= start) {

                if (first) {

                    list.add(movie);

                    if (countedItem == 4) {
                        mController.firstItemList(list);
                    }
                }
                else {
                    mController.addItem(movie);
                }

                countedItem++;
            }
        }
    }
}
