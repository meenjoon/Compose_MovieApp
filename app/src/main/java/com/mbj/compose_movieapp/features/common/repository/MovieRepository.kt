package com.mbj.compose_movieapp.features.common.repository

import com.mbj.compose_movieapp.features.common.entity.CategoryEntity
import com.mbj.compose_movieapp.features.common.entity.EntityWrapper
import com.mbj.compose_movieapp.features.common.entity.MovieDetailEntity
import com.mbj.compose_movieapp.features.common.network.api.IMovieAppNetworkApi
import com.mbj.compose_movieapp.features.feed.data.FeedConstants
import com.mbj.compose_movieapp.features.feed.data.mapper.CategoryMapper
import com.mbj.compose_movieapp.features.feed.domain.enum.SortOrder
import com.mbj.compose_movieapp.library.network.model.ApiResponse
import com.mbj.compose_movieapp.library.storage.IStorage
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieNetworkApi: IMovieAppNetworkApi,
    private val storage: IStorage,
    private val categoryMapper: CategoryMapper
) : IMovieDataSource {
    override suspend fun getCategories(sortOrder: SortOrder?): EntityWrapper<List<CategoryEntity>> {
        return categoryMapper.mapFromResult(
            result = movieNetworkApi.getMovies(),
            extra = sortOrder
        )
    }

    override suspend fun getMovieDetail(movieName: String): MovieDetailEntity {
        return storage
            .get<List<MovieDetailEntity>>(FeedConstants.MOVIE_LIST_KEY)
            ?.single { it.title == movieName }
            ?: MovieDetailEntity()
    }
}
