package ro.alexmamo.optimizerealtimedatabase.presentation.products.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import ro.alexmamo.optimizerealtimedatabase.core.Constants.PRODUCTS_SCREEN

@Composable
fun ProductsTopBar() {
    TopAppBar (
        title = {
            Text(
                text = PRODUCTS_SCREEN
            )
        }
    )
}