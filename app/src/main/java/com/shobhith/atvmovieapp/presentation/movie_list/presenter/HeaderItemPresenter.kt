package com.shobhith.atvmovieapp.presentation.movie_list.presenter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.Presenter
import androidx.leanback.widget.RowHeaderPresenter
import com.shobhith.atvmovieapp.databinding.ItemHeaderViewBinding
import com.shobhith.atvmovieapp.presentation.movie_list.ui.CustomHeader

class HeaderItemPresenter : RowHeaderPresenter() {
    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = ItemHeaderViewBinding.inflate(inflater, parent, false)
        return HeaderViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: Presenter.ViewHolder, item: Any) {
        val data = (item as ListRow).headerItem as CustomHeader
        val view = viewHolder as HeaderViewHolder
        view.bind(data)
    }

    override fun onUnbindViewHolder(viewHolder: Presenter.ViewHolder?) {
    }

    inner class HeaderViewHolder(private val binding: ItemHeaderViewBinding) : ViewHolder(binding.root) {
        fun bind(customHeader: CustomHeader) {
            binding.apply {
                tvTitle.text = customHeader.headerName
                ivIcon.setImageResource(customHeader.icon)
            }
        }
    }
}