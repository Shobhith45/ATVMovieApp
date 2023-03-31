package com.shobhith.atvmovieapp.presentation.movie_list.presenter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.leanback.widget.Presenter
import com.bumptech.glide.Glide
import com.shobhith.atvmovieapp.R
import com.shobhith.atvmovieapp.databinding.ItemMovieCardBinding
import com.shobhith.atvmovieapp.domain.model.Movie
import com.shobhith.atvmovieapp.util.Constant

class MovieCardPresenter : Presenter() {
    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = ItemMovieCardBinding.inflate(inflater, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any) {
        if (item is Movie) {
            val holder = viewHolder as CardViewHolder
            holder.bind(item)
        }
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder) {

    }

    inner class CardViewHolder(private val binding: ItemMovieCardBinding) : Presenter.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.apply {
                Glide.with(root.context)
                    .load("${Constant.THUMB_URL}${movie.posterPath}")
                    .placeholder(R.drawable.ic_loading)
                    .into(ivBanner)
                tvName.text = movie.title
                tvRating.text = movie.voteAverage.toString()
            }
        }
    }
}