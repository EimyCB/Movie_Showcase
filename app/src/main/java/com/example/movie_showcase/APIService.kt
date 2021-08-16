package com.example.movie_showcase
 

import com.example.movie_showcase.ResponsesClass.DetailedMovie
import com.example.movie_showcase.ResponsesClass.PopularMoviesResponse
import com.example.movie_showcase.ResponsesClass.Movies
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

private const val apiKey ="d3df733f5805e124ca7adead9d2b1ef2"


interface APIService{
    @GET ("popular?api_key=$apiKey")
    suspend fun getPopularMovies(): Response<PopularMoviesResponse>

   @GET("{movie_id}?api_key=$apiKey")
    suspend fun getMovieDetails( @Path("movie_id") id:Int): Response<DetailedMovie>

}




