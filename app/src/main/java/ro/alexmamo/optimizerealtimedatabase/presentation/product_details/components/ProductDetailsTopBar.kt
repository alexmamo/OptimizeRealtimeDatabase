package ro.alexmamo.optimizerealtimedatabase.presentation.product_details.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import ro.alexmamo.optimizerealtimedatabase.core.Constants.PRODUCT_DETAILS_SCREEN

@Composable
fun ProductDetailsTopBar(
    navigateToProductNamesScreen: () -> Unit
) {
    TopAppBar (
        title = {
            Text(
                text = PRODUCT_DETAILS_SCREEN
            )
        },
        navigationIcon = {
            IconButton(
                onClick = navigateToProductNamesScreen
            ) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = null,
                )
            }
        }
    )
}