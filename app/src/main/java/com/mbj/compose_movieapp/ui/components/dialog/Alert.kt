package com.mbj.compose_movieapp.ui.components.dialog

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.mbj.compose_movieapp.R
import com.mbj.compose_movieapp.ui.models.dialog.DialogButton
import com.mbj.compose_movieapp.ui.models.dialog.DialogContent
import com.mbj.compose_movieapp.ui.models.dialog.DialogText
import com.mbj.compose_movieapp.ui.models.dialog.DialogTitle

@Composable
fun DialogPopup.Alert(
    title: String,
    bodyText: String,
    buttons: List<DialogButton>
) {
    BaseDialogPopup(
        dialogTitle = DialogTitle.Header(title),
        dialogContent = DialogContent.Large(
            DialogText.Default(
                bodyText
            )
        ),
        buttons = buttons
    )
}
