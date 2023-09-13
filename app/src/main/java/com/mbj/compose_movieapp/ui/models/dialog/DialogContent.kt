package com.mbj.compose_movieapp.ui.models.dialog

/**
 * Defalut와 Large는 내용이 같기때문에 DialogText.Default와 동등한 코드를 사용하지만,
 * 보여지는 방식이 다르기 때문에 DialogTitle에서 Defalut면 글자를 작게 보여주고 Large면 글자를 크게 보여준다.
 */

sealed class DialogContent {
    data class Default(
        val dialogText: DialogText.Default
    ) : DialogContent()

    data class Large(
        val dialogText: DialogText.Default
    ) : DialogContent()

    data class Rating(
        val dialogText: DialogText.Rating
    ) : DialogContent()
}
