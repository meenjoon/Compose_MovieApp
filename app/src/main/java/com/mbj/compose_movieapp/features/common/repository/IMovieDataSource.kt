package com.mbj.compose_movieapp.features.common.repository

interface IMovieDataSource {
    suspend fun getMovieList()
}
