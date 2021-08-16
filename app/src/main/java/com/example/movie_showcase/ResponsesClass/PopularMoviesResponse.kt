package com.example.movie_showcase.ResponsesClass

import com.google.gson.annotations.SerializedName

data class PopularMoviesResponse (
    @SerializedName("page")val page:Int,
    @SerializedName("results")val movies: List<Movies>,
    @SerializedName("total_results")val total_results:Int,
    @SerializedName("total_pages")val total_pages:Int
)
data class Movies (
    @SerializedName("poster_path") val poster:String?,
    @SerializedName("adult")val adult:Boolean,
    @SerializedName("overview")val overview:String,
    @SerializedName("release_date") val releaseDate:String,
    @SerializedName("genre_ids") val genreId:List<Int>,
    @SerializedName("id") val id:Int,
    @SerializedName("original_title") val originalTitle:String,
    @SerializedName("original_language") val originalLanguage:String,
    @SerializedName("title") val title:String,
    @SerializedName("backdrop_path") val logo:String?,
    @SerializedName("popularity") val popularity:Number,
    @SerializedName("vote_count") val voteCount:Int,
    @SerializedName("video") val video:Boolean,
    @SerializedName("vote_average") val voteAverage: Number
)




