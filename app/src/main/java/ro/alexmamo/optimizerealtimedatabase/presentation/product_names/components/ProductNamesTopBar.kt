package ro.alexmamo.optimizerealtimedatabase.presentation.product_names.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import ro.alexmamo.optimizerealtimedatabase.core.Constants.PRODUCT_NAMES_SCREEN

@Composable
fun ProductNamesTopBar() {
    TopAppBar (
        title = {
            Text(
                text = PRODUCT_NAMES_SCREEN
            )
        }
    )
}