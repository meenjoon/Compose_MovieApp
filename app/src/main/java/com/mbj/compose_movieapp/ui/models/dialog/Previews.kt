package com.mbj.compose_movieapp.ui.models.dialog

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.mbj.compose_movieapp.R
import com.mbj.compose_movieapp.ui.components.dialog.Alert
import com.mbj.compose_movieapp.ui.components.dialog.Default
import com.mbj.compose_movieapp.ui.components.dialog.DialogPopup
import com.mbj.compose_movieapp.ui.components.dialog.Rating
import com.mbj.compose_movieapp.ui.models.buttons.LeadingIconData
import com.mbj.compose_movieapp.ui.theme.Compose_MovieAppTheme

@Preview
@Composable
fun AlertPreview() {
    Compose_MovieAppTheme {
        DialogPopup.Alert(
            title = "Title",
            bodyText = "bodyText",
            buttons = listOf(
                DialogButton.UnderlinedText("Okay") {},
            )
        )
    }
}

@Preview
@Composable
fun DefaultPreview() {
    Compose_MovieAppTheme {
        DialogPopup.Default(
            title = "Title",
            bodyText = "bodyText",
            buttons = listOf(
                DialogButton.Primary("Open") {},
                DialogButton.SecondaryBorderless("CANCEL") {},
            )
        )
    }
}

@Preview
@Composable
fun RatingPreview() {
    Compose_MovieAppTheme {
        DialogPopup.Rating(
            movieName = "The Lord of the Rings: The Two Towers",
            rating = 7.5f,
            buttons = listOf(
                DialogButton.Primary(
                    title = "Open",
                    leadingIconData = LeadingIconData(
                        iconDrawable = R.drawable.ic_send,
                        iconContentDescription = null
                    )
                ) {},
                DialogButton.SecondaryBorderless("CANCEL") {},
            )
        )
    }
}

