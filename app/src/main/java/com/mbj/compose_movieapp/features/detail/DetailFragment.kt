package com.mbj.compose_movieapp.features.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.mbj.compose_movieapp.features.detail.presentation.MovieDetailScreen
import com.mbj.compose_movieapp.features.detail.presentation.viewmodel.MovieDetailViewModel
import com.mbj.compose_movieapp.ui.navigation.safeNavigate
import com.mbj.compose_movieapp.ui.theme.Compose_MovieAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import com.mbj.compose_movieapp.features.detail.presentation.input.*
import com.mbj.compose_movieapp.features.detail.presentation.output.*


@AndroidEntryPoint
class DetailFragment: Fragment() {

    private val viewModel: MovieDetailViewModel by viewModels()
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        init()
        observeUiEffects()
        return ComposeView(requireContext()).apply {
            setContent {
                Compose_MovieAppTheme {
                    MovieDetailScreen(
                        movieDetailState = viewModel.outputs.detailState.collectAsState(),
                        input = viewModel.inputs
                    )
                }
            }
        }
    }

    private fun init() {
        lifecycleScope.launch {
            viewModel.initMovieName(args.movieName)
        }

    }

    private fun observeUiEffects() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.outputs.detailUiEffect.collectLatest {
                    when (it) {
                        is DetailUiEffect.Back -> {
                            findNavController().navigateUp()
                        }

                        is DetailUiEffect.OpenUrl -> {
//                            findNavController().safeNavigate(
//                                DetailFragmentDirections.actionDetailToImdbDialog(
//                                    it.url
//                                )
//                            )
                        }

                        is DetailUiEffect.RateMovie -> {
//                            findNavController().safeNavigate(
//                                DetailFragmentDirections.actionDetailToRating(
//                                    movieName = it.movieTitle,
//                                    rating = it.rating
//                                )
//                            )
                        }
                    }
                }
            }
        }
    }
}
