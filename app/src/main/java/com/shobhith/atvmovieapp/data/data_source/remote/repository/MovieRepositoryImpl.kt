package com.shobhith.atvmovieapp.data.data_source.remote.repository

import com.shobhith.atvmovieapp.data.data_source.remote.service.MovieApi
import com.shobhith.atvmovieapp.domain.model.MovieResponse
import com.shobhith.atvmovieapp.domain.repository.MovieRepository
import retrofit2.Response

class MovieRepositoryImpl(private val movieApi: MovieApi) : MovieRepository {
    override suspend fun getPopularMovies(apiKey: String): Response<MovieResponse> = movieApi.getPopularMovies(apiKey)
}