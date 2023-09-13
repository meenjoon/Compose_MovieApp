package com.mbj.compose_movieapp.ui.components.movie

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import com.mbj.compose_movieapp.R
import com.mbj.compose_movieapp.features.common.entity.MovieDetailEntity
import com.mbj.compose_movieapp.features.common.entity.MovieFeedItemEntity
import com.mbj.compose_movieapp.features.feed.presentation.viewmodel.input.IFeedViewModelInput
import com.mbj.compose_movieapp.ui.theme.Compose_MovieAppTheme
import com.mbj.compose_movieapp.ui.theme.Paddings

private val CARD_WIDTH = 150.dp
private val ICON_SIZE = 12.dp

@Composable
fun MovieItem(
    movie: MovieFeedItemEntity,
    input: IFeedViewModelInput
) {
    Column(
        modifier = Modifier
            .width(CARD_WIDTH)
            .padding(Paddings.large)
    ) {
        Poster(
            thumbnailMovie = movie,
            input = input
        )

        Text(
            text = movie.title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(
                top = Paddings.large
            ),
            style = MaterialTheme.typography.body2
        )

        Row(
            modifier = Modifier.padding(
                vertical = Paddings.medium
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .padding(Paddings.small)
                    .size(ICON_SIZE),
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_rating),
                tint = Color.Black.copy(
                    alpha = 0.5f
                ),
                contentDescription = "rating icon"
            )
            Text(
                text = "${movie.rating}",
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.onSurface.copy(
                    alpha = 0.5f
                )
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Poster(
    thumbnailMovie: MovieFeedItemEntity,
    input: IFeedViewModelInput
) {
    Card(
        onClick = {
            input.openDetail(thumbnailMovie.title)
        }
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest
                    .Builder(LocalContext.current)
                    .data(data = thumbnailMovie.thumbUrl)
                    .apply {
                        crossfade(true)
                        scale(Scale.FILL)
                    }.build()
            ),
            modifier = Modifier
                .width(CARD_WIDTH)
                .height(200.dp),
            contentScale = ContentScale.FillHeight,
            contentDescription = "Movie Poster Image"
        )
    }
}
