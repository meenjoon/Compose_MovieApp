package com.mbj.compose_movieapp.features.feed.presentation.viewmodel.input

interface IFeedViewModelInput {
    fun openDetail(movieName: String)
    fun openInfoDialog()
    fun refreshFeed()
}
