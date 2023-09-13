package com.mbj.compose_movieapp.features.detail.domain.usecase

import com.mbj.compose_movieapp.features.common.entity.MovieDetailEntity


interface IGetMovieDetailUseCase {
    suspend operator fun invoke(name: String): MovieDetailEntity
}
