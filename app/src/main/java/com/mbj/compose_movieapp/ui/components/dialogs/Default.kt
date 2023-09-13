package com.mbj.compose_movieapp.ui.components.dialogs

import androidx.compose.runtime.Composable
import com.mbj.compose_movieapp.ui.models.dialog.DialogButton
import com.mbj.compose_movieapp.ui.models.dialog.DialogContent
import com.mbj.compose_movieapp.ui.models.dialog.DialogText
import com.mbj.compose_movieapp.ui.models.dialog.DialogTitle

object DialogPopup

@Composable
fun DialogPopup.Default(
    title: String,
    bodyText: String,
    buttons: List<DialogButton>
) {
    BaseDialogPopup(
        dialogTitle = DialogTitle.Default(title),
        dialogContent = DialogContent.Default(
            DialogText.Default(bodyText)
        ),
        buttons = buttons
    )
}

