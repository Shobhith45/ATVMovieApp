package com.shobhith.atvmovieapp.presentation.movie_list.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter
import androidx.leanback.widget.Presenter
import androidx.leanback.widget.PresenterSelector
import com.shobhith.atvmovieapp.R
import com.shobhith.atvmovieapp.domain.model.Movie
import com.shobhith.atvmovieapp.domain.model.NavHeader
import com.shobhith.atvmovieapp.presentation.movie_list.presenter.HeaderItemPresenter
import com.shobhith.atvmovieapp.presentation.movie_list.presenter.MovieCardPresenter
import com.shobhith.atvmovieapp.presentation.movie_list.viewmodel.MovieListViewModel
import com.shobhith.atvmovieapp.util.Constant
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieListFragment : BrowseSupportFragment() {

    private val viewModel: MovieListViewModel by viewModel()
    private lateinit var rowsAdapter: ArrayObjectAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpUI()
        rowsAdapter = ArrayObjectAdapter(ListRowPresenter())
        observeMovieResponse()
        setClickListeners()
        setHeaderPresenterSelector(object : PresenterSelector(){
            override fun getPresenter(item: Any?): Presenter {
                return HeaderItemPresenter()
            }

        })
    }

    private fun setClickListeners() {
        setOnSearchClickedListener {
            Toast.makeText(context, "Clicked on Search", Toast.LENGTH_SHORT).show()
        }
        setOnItemViewClickedListener { itemViewHolder, item, rowViewHolder, row ->
            Log.d("movie app", item.toString())
        }
    }

    private fun observeMovieResponse() {
        viewModel.movieListState.observe(viewLifecycleOwner) {
            when (it) {
                is MovieListState.Loading -> {
                    progressBarManager.show()
                }
                is MovieListState.Error -> {
                }
                is MovieListState.MoviesFetched -> {
                    progressBarManager.hide()
                    for (cat in Constant.movieCategories) {
                        createRows(cat, it.movies)
                    }
                    adapter = rowsAdapter
                }
            }
        }
    }

    private fun createRows(cat: NavHeader, movies: List<Movie>?) {
        val cardAdapter = ArrayObjectAdapter(MovieCardPresenter())
        val headerItem = CustomHeader(cat.id, cat.name, cat.icon)
        movies?.let {
            for (movie in it.shuffled()) {
                cardAdapter.add(movie)
            }
            rowsAdapter.add(ListRow(headerItem, cardAdapter))
        }
    }

    private fun setUpUI() {
        title = "TMDB Movies"
        badgeDrawable = ResourcesCompat.getDrawable(resources, R.drawable.ic_logo, null)
        brandColor = ResourcesCompat.getColor(resources, R.color.light_blue, null)
        searchAffordanceColor = ResourcesCompat.getColor(resources, R.color.light_blue, null)
    }
}