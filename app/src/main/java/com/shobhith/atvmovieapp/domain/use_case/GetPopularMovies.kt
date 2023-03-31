package com.shobhith.atvmovieapp.domain.use_case

import com.shobhith.atvmovieapp.domain.repository.MovieRepository
import com.shobhith.atvmovieapp.util.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class GetPopularMovies(private val movieRepository: MovieRepository) {
    suspend operator fun invoke(apiKey: String) =
        flow {
            try {
                emit(Resource.loading())
                val data = movieRepository.getPopularMovies(apiKey)
                delay(5000L)
                emit(Resource.success(data.body()?.results))
            } catch (e: Exception) {
                emit(Resource.error(e.message.toString()))
            }

        }
}