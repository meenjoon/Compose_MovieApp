package com.mbj.compose_movieapp.features.detail.presentation.output

import com.mbj.compose_movieapp.features.common.entity.MovieDetailEntity


sealed class MovieDetailState {
    object Initial : MovieDetailState()
    class Main(val movieDetailEntity: MovieDetailEntity) : MovieDetailState()
}
