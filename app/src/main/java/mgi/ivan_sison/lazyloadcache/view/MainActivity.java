package mgi.ivan_sison.lazyloadcache.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import mgi.ivan_sison.lazyloadcache.R;
import mgi.ivan_sison.lazyloadcache.controller.movie.MovieInterface;
import mgi.ivan_sison.lazyloadcache.controller.view.MainController;
import mgi.ivan_sison.lazyloadcache.controller.view.MainInterface;
import mgi.ivan_sison.lazyloadcache.model.Movie;

public class MainActivity extends AppCompatActivity implements MainInterface, MovieInterface {

    private static final String TAG = "MainActivity";
    private MainController mController;

    private RecyclerView mRecycler;
    private ProgressBar mProgressBar;
    private MainAdapter mAdapter;

    private boolean notified = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mController = new MainController(this, this, this);

        initObj();

        //mController.getMovies();
        mController.getMoviesPerPage();
    }

    private void initObj() {
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        mRecycler = (RecyclerView) findViewById(R.id.main_recycler);
        mRecycler.setLayoutManager(layoutManager);
        mRecycler.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                mController.onScrollView(layoutManager);
            }
        });

        mProgressBar = (ProgressBar) findViewById(R.id.main_progress_bar);
    }

    @Override
    public void onDataFetch(ArrayList list) {
        mAdapter = new MainAdapter(mController, list);
        mRecycler.setAdapter(mAdapter);
    }

    @Override
    public void onDataFetchMore(Movie movie) {
        mAdapter.addItem(movie);
    }

    @Override
    public void onDataFetchAll(ArrayList list) {
        mAdapter = new MainAdapter(mController, list);
        mRecycler.setAdapter(mAdapter);
    }

    @Override
    public void onDataFetchAllLoaded() {
        if (!notified) {
            notified = true;
            Toast.makeText(this, "No more data", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onDataFetching() {

    }

    @Override
    public void onDataFinishedFetching() {

    }

    @Override
    public void onFailure() {
        Toast.makeText(this, "No data found!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onShowProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onFinishedProgress() {
        mProgressBar.setVisibility(View.INVISIBLE);
    }
}
