package mgi.ivan_sison.lazyloadcache.view;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import mgi.ivan_sison.lazyloadcache.R;
import mgi.ivan_sison.lazyloadcache.controller.view.MainController;
import mgi.ivan_sison.lazyloadcache.model.Movie;

/**
 * Created by MGI-Ivan on 08/01/2018.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private static final String TAG = "MainAdapter";

    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;

    private ArrayList items = new ArrayList();

    private MainController mController;

    public MainAdapter(MainController mController, ArrayList items) {
        this.mController = mController;
        this.items = items;
    }

    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_movie, parent, false);
        return new MainAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MainAdapter.ViewHolder holder, final int position) {
        final Movie movie = (Movie) items.get(position);

        holder.textItem.setText(movie.getMovieName());
        holder.textDesc.setText(movie.getMovieDesc());

        if (!movie.getMovieImage().isEmpty()) {
            Picasso.with(mController.getApp().getApplicationContext()).load(movie.getMovieImage()).fit().into(holder.image);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Movie movie) {
        items.add(movie);
        notifyDataSetChanged();
    }

    public void removedItem(int position) {
        items.remove(position);
        notifyItemRemoved(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textItem;
        private TextView textDesc;
        private ImageView image;

        private View view;

        public ViewHolder(View view) {
            super(view);
            this.view = view;

            textItem = (TextView) view.findViewById(R.id.movie_name);
            textDesc = (TextView) view.findViewById(R.id.movie_desc);
            image = (ImageView) view.findViewById(R.id.movie_image);
        }
    }

    public class LoadingHolder extends RecyclerView.ViewHolder {

        private ProgressBar progressBar;

        private View view;

        public LoadingHolder(View view) {
            super(view);
            this.view = view;

            progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
        }
    }
}
