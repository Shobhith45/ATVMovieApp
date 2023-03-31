package com.shobhith.atvmovieapp.presentation.movie_list.ui

import com.shobhith.atvmovieapp.domain.model.Movie

sealed class MovieListState {

    data class MoviesFetched(val movies: List<Movie>?) : MovieListState()

    object Loading : MovieListState()

    data class Error(val errorMessage: String?) : MovieListState()
}