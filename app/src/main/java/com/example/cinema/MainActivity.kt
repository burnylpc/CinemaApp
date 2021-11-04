package com.example.cinema

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cinema.features.movies_cards_screen.ui.MovieCardsScreenFragment

class MainActivity : AppCompatActivity() {

    //private var layoutManager: RecyclerView.LayoutManager? = null
    //private var adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>? = null
    //private val viewModel by viewModel<MovieListScreenViewModel>()
    //private val adapter by lazy { MovieCardsScreenAdapter(listOf()) }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.root, MovieCardsScreenFragment()).commit()




//        val recyclerView = findViewById<RecyclerView>(R.id)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.adapter = adapter
//
//        //viewModel.viewState.observe(::render)
    }

//    private fun render(view: ViewState) {
//       // adapter.updateMovieCards(viewState.)
//    }



}