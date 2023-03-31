package com.shobhith.atvmovieapp.data.data_source.remote.service

import com.shobhith.atvmovieapp.domain.model.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("/3/movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String) : Response<MovieResponse>

}