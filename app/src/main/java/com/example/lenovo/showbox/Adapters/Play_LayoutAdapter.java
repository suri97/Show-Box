package com.example.lenovo.showbox.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.showbox.Networking.Movies1;
import com.example.lenovo.showbox.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Lenovo on 26-10-2017.
 */

public class Play_LayoutAdapter extends RecyclerView.Adapter<Play_LayoutAdapter.MovieViewHolder> {

    private Context mContext;
    private Movies1.Movies mMovies[];
    private Play_LayoutAdapter.MovieClickListener mListener;

    @Override
    public Play_LayoutAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.row_layout,parent,false);
        return new Play_LayoutAdapter.MovieViewHolder(itemView,mListener);
    }

    @Override
    public void onBindViewHolder(Play_LayoutAdapter.MovieViewHolder holder, int position) {

        Movies1.Movies movie = mMovies[position];
        holder.titleTextView.setText(movie.getTitle());
        holder.dateTextView.setText(movie.getRelease_date());
        if(movie.getAdult()==false){
            holder.adultTextView.setText("U/A");
        }
        else{
            holder.adultTextView.setText("ADULT");
        }
        holder.voteTextView.setText(movie.getVote_average() + "");
        Picasso.with(mContext).load(movie.getPoster()).resize(2300, 1000).centerInside().into(holder.poster);

    }

    @Override
    public int getItemCount() {
        return mMovies.length;
    }

    public interface MovieClickListener {
        void onItemClick(View view,int position);
    }


    public Play_LayoutAdapter(Context context,Movies1.Movies movies1[]){
        mContext = context;
        this.mMovies = movies1;
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView titleTextView;
        TextView voteTextView;
        TextView adultTextView;
        TextView dateTextView;
        ImageView poster;
        Play_LayoutAdapter.MovieClickListener mMovieClickListener;

        public MovieViewHolder(View itemView,Play_LayoutAdapter.MovieClickListener listener) {
            super(itemView);
            itemView.setOnClickListener(this);
            mMovieClickListener = listener;
            titleTextView = (TextView) itemView.findViewById(R.id.title);
            voteTextView = (TextView) itemView.findViewById(R.id.vote);
            adultTextView = (TextView) itemView.findViewById(R.id.adult);
            dateTextView = (TextView) itemView.findViewById(R.id.date);
            poster = (ImageView) itemView.findViewById(R.id.poster);
        }

        @Override
        public void onClick(View view) {
            int id = view.getId();
            int position = getAdapterPosition();
            if(position != RecyclerView.NO_POSITION){
                if(id == R.id.recyclerView){
                    mMovieClickListener.onItemClick(view,position);
                }
            }

        }
    }
}


