package com.example.jorgeluis.testRetrofit;

/**
 * Created by Jorge Luis on 20/09/2016.
 */
import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jorgeluis.testRetrofit.Model.Alumno;


import java.util.List;



public class AlumnosAdapter extends RecyclerView.Adapter<AlumnosAdapter.MovieViewHolder> {


    private List<Alumno> movies;
    private int rowLayout;
    private Context context;


    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView movieTitle;
        TextView data;
        TextView movieDescription;
        TextView rating;


        public MovieViewHolder(View v) {
            super(v);
            moviesLayout = (LinearLayout) v.findViewById(R.id.movies_layout);
            movieTitle = (TextView) v.findViewById(R.id.title);
            data = (TextView) v.findViewById(R.id.subtitle);
            movieDescription = (TextView) v.findViewById(R.id.description);
            rating = (TextView) v.findViewById(R.id.rating);
        }
    }

    public AlumnosAdapter(List<Alumno> movies, int rowLayout, Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public AlumnosAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        holder.movieTitle.setText(String.valueOf(movies.get(position).getIdAlumno()));
        holder.data.setText(movies.get(position).getNombre());
        holder.movieDescription.setText(movies.get(position).getDireccion());

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}