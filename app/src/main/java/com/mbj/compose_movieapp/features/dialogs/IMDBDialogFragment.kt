package com.mbj.compose_movieapp.features.dialogs

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.stringResource
import androidx.navigation.fragment.navArgs
import com.mbj.compose_movieapp.BaseDialogFragment
import com.mbj.compose_movieapp.R
import com.mbj.compose_movieapp.ui.components.dialogs.Default
import com.mbj.compose_movieapp.ui.components.dialogs.DialogPopup
import com.mbj.compose_movieapp.ui.models.dialog.DialogButton
import com.mbj.compose_movieapp.ui.theme.Compose_MovieAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IMDBDialogFragment : BaseDialogFragment() {

    private val args: IMDBDialogFragmentArgs by navArgs()

    val IMDB_BASE_URL = "https://m.imdb.com"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dialog?.apply {
            isCancelable = true
            setCanceledOnTouchOutside(true)
            window?.setBackgroundDrawable(ColorDrawable(requireContext().getColor(android.R.color.transparent)))
        }

        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                Compose_MovieAppTheme (
//                    themeState = themeViewModel.themeState.collectAsState()
                ) {
                    DialogPopup.Default(
                        title = stringResource(R.string.imdb_title),
                        bodyText = stringResource(R.string.imdb_message),
                        buttons = listOf(
                            DialogButton.Primary(getString(R.string.open)) {
                                startActivity(
                                    Intent(
                                        Intent.ACTION_VIEW,
                                        Uri.parse(IMDB_BASE_URL + args.url)
                                    )
                                )
                            },
                            DialogButton.SecondaryBorderless(getString(R.string.cancel)) {
                                dismiss()
                            }
                        )
                    )
                }
            }
        }
    }
}
