package com.shobhith.atvmovieapp.presentation.movie_list.ui

import androidx.leanback.widget.HeaderItem

data class CustomHeader(val headerId: Long, val headerName: String, val icon: Int) :
    HeaderItem(headerId, headerName)