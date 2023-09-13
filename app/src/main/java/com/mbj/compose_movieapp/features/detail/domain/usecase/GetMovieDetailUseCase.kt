package com.mbj.compose_movieapp.features.detail.domain.usecase

import com.mbj.compose_movieapp.features.common.entity.MovieDetailEntity
import com.mbj.compose_movieapp.features.common.repository.IMovieDataSource
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(
    private val dataSource: IMovieDataSource
) : IGetMovieDetailUseCase {
    override suspend fun invoke(name: String): MovieDetailEntity {
        return dataSource.getMovieDetail(name)
    }
}
