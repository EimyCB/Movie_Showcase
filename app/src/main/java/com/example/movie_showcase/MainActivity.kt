package com.example.movie_showcase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movie_showcase.ResponsesClass.Movies
import com.example.movie_showcase.ResponsesClass.PopularMoviesResponse
import com.example.movie_showcase.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val moviePosters = mutableListOf<Movies>()
      private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        getPosters()

    }


    private fun initRecyclerView() {

        val SuicideSquad : Movies = Movies("/e1mjopzAS2KNsvpbpahQ1a6SkSn.jpg", false,"","", listOf(1,2), 2312, "Suicide","","","",342,2345,video = false,2323)

        adapter = MovieAdapter(moviePosters)
        binding.rvMovies.layoutManager = LinearLayoutManager(this)
        binding.rvMovies.adapter = adapter
    }

    private fun getPosters() {
        CoroutineScope(Dispatchers.IO).launch {
            val llamada = getRetroFit().create(APIService::class.java)
                .getPopularMovies()
            val responseMovie : PopularMoviesResponse? = llamada.body()

            runOnUiThread{
            if(llamada.isSuccessful) {
                val postersCarga = responseMovie?.movies ?: emptyList()
                moviePosters.clear()
                moviePosters.addAll(postersCarga)
                adapter.notifyDataSetChanged()
            }
         }
    } }

    private fun getRetroFit(): Retrofit {
            return Retrofit.Builder ()
                .baseUrl ( "https://api.themoviedb.org/3/movie/" )
                .addConverterFactory(GsonConverterFactory.create())
                .build()
         }
}




