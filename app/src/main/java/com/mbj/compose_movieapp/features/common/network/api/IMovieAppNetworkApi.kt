package com.mbj.compose_movieapp.features.common.network.api

import com.mbj.compose_movieapp.features.common.network.model.MovieResponse
import com.mbj.compose_movieapp.library.network.model.ApiResult

interface IMovieAppNetworkApi {
    suspend fun getMovies(): ApiResult<List<MovieResponse>>
}
