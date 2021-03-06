package com.example.lenovo.showbox.Networking;

import com.example.lenovo.showbox.Activities.Search_Activity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Lenovo on 22-10-2017.
 */


public interface Services {


    //MOVIEs
    @GET("movie/popular?api_key=4db11af8b81b5f51233f56e9078e9c07&language=en-US&page=2")
    Call<Movies1> getMovies();

    @GET("movie/upcoming?api_key=4db11af8b81b5f51233f56e9078e9c07&language=en-US&page=2")
    Call<Movies1> getUpcomingMovies();

    @GET("movie/top_rated?api_key=4db11af8b81b5f51233f56e9078e9c07&language=en-US&page=1")
    Call<Movies1> getTopRatedMovies();

    @GET("movie/now_playing?api_key=4db11af8b81b5f51233f56e9078e9c07&language=en-US&page=1")
    Call<Movies1> getPlayingMovies();

    @GET("search/movie?api_key=4db11af8b81b5f51233f56e9078e9c07&language=en-US&query")
    Call<Movies1> searchMovies(@Query("query") String query);


    //TV SHOWS
    @GET("tv/popular?api_key=4db11af8b81b5f51233f56e9078e9c07&language=en-US&page=1")
    Call<TvShows1> getPopularTvShows();

    @GET("tv/airing_today?api_key=4db11af8b81b5f51233f56e9078e9c07&language=en-US&page=2")
    Call<TvShows1> getTodaysShows();

    @GET("tv/top_rated?api_key=4db11af8b81b5f51233f56e9078e9c07&language=en-US&page=1")
    Call<TvShows1> getTopRatedTvShows();

    @GET("tv/on_the_air?api_key=4db11af8b81b5f51233f56e9078e9c07&language=en-US&page=1")
    Call<TvShows1> getOnAirTvShows();

    @GET("search/tv/?api_key=4db11af8b81b5f51233f56e9078e9c07&language=en-US&query")
    Call<TvShows1> searchTvShows(@Query("query") String query);



}
