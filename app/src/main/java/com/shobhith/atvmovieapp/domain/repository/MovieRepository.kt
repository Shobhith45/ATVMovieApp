package com.shobhith.atvmovieapp.domain.repository

import com.shobhith.atvmovieapp.domain.model.MovieResponse
import retrofit2.Response

interface MovieRepository {
    suspend fun getPopularMovies(apiKey: String) : Response<MovieResponse>
}