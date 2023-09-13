package com.mbj.compose_movieapp.features.common.repository

import com.mbj.compose_movieapp.features.common.entity.CategoryEntity
import com.mbj.compose_movieapp.features.common.entity.EntityWrapper
import com.mbj.compose_movieapp.features.common.entity.MovieDetailEntity
import com.mbj.compose_movieapp.features.feed.domain.enum.SortOrder

interface IMovieDataSource {
    suspend fun getCategories(sortOrder: SortOrder? = null): EntityWrapper<List<CategoryEntity>>
    suspend fun getMovieDetail(movieName: String): MovieDetailEntity
}
