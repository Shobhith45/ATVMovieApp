package com.shobhith.atvmovieapp.di

import com.shobhith.atvmovieapp.data.data_source.remote.repository.MovieRepositoryImpl
import com.shobhith.atvmovieapp.data.data_source.remote.service.MovieApi
import com.shobhith.atvmovieapp.domain.repository.MovieRepository
import com.shobhith.atvmovieapp.domain.use_case.GetPopularMovies
import com.shobhith.atvmovieapp.presentation.movie_list.viewmodel.MovieListViewModel
import com.shobhith.atvmovieapp.util.Constant
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single { provideRetrofit() }
    single { provideMovieApi(get()) }
    viewModel { MovieListViewModel(get()) }
    factory { provideMovieRepository(get()) }
    factory { provideGetPopularMovies(get()) }

}
fun provideRetrofit() : Retrofit {
    return Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .baseUrl(Constant.BASE_URL)
        .build()
}

fun provideMovieApi(retrofit: Retrofit) : MovieApi {
    return retrofit.create(MovieApi::class.java)
}

fun provideMovieRepository(movieApi: MovieApi) : MovieRepository {
    return MovieRepositoryImpl(movieApi)
}

fun provideGetPopularMovies(repository: MovieRepository) : GetPopularMovies {
    return GetPopularMovies(repository)
}