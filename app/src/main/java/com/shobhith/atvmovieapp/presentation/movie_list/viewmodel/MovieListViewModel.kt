package com.shobhith.atvmovieapp.presentation.movie_list.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shobhith.atvmovieapp.domain.use_case.GetPopularMovies
import com.shobhith.atvmovieapp.presentation.movie_list.ui.MovieListState
import com.shobhith.atvmovieapp.util.Constant
import com.shobhith.atvmovieapp.util.Status
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MovieListViewModel(
    private val getPopularMovies: GetPopularMovies
) : ViewModel() {
    private val _movieListState = MutableLiveData<MovieListState>()
    val movieListState : LiveData<MovieListState> get() = _movieListState

    init {
        fetchPopularMovies()
    }


    private fun fetchPopularMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            getPopularMovies(Constant.API_KEY).collectLatest {
                when(it.status) {
                    Status.LOADING -> {
                        _movieListState.postValue(MovieListState.Loading)
                    }
                    Status.SUCCESS -> {
                        _movieListState.postValue(MovieListState.MoviesFetched(it.data))
                    }
                    Status.ERROR -> {
                        _movieListState.postValue(MovieListState.Error(it.message))
                    }
                }
            }
        }
    }
}