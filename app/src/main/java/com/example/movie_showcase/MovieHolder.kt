package com.example.movie_showcase

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.movie_showcase.ResponsesClass.Movies
import com.example.movie_showcase.databinding.PostersBinding
import com.squareup.picasso.Picasso

class MovieHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = PostersBinding.bind(view)

    fun bind(movies: Movies) {
        val imgUrl = "https://image.tmdb.org/t/p/original".plus(movies.poster)
        Picasso.get()
            .load(imgUrl).
            into(binding.ivPoster)
        binding.tvMovieName.text = movies.title
    }
}