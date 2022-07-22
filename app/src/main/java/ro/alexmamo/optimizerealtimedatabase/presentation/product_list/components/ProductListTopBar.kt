package ro.alexmamo.optimizerealtimedatabase.presentation.product_list.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import ro.alexmamo.optimizerealtimedatabase.core.Constants.PRODUCT_LIST_SCREEN

@Composable
fun ProductListTopBar() {
    TopAppBar (
        title = {
            Text(
                text = PRODUCT_LIST_SCREEN
            )
        }
    )
}