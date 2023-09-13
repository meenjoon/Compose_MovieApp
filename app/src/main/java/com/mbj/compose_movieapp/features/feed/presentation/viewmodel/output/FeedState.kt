package com.mbj.compose_movieapp.features.feed.presentation.viewmodel.output

import com.mbj.compose_movieapp.features.common.entity.CategoryEntity

sealed class FeedState {
    object Loading: FeedState()
    class Main(
        val categories: List<CategoryEntity>
    ): FeedState()
    class Failed(
        val reason: String
    ): FeedState()
}
