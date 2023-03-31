package com.shobhith.atvmovieapp.presentation.movie_list.ui

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.shobhith.atvmovieapp.R

class MovieListActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)
    }
}