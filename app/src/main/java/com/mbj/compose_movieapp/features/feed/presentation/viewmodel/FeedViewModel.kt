package com.mbj.compose_movieapp.features.feed.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mbj.compose_movieapp.features.common.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val movieRepository: MovieRepository
): ViewModel() {
    fun getMovies() {
        viewModelScope.launch {
            movieRepository.getMovieList()
        }
    }
}
