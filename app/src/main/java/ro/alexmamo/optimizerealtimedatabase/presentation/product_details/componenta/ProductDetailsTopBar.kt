package ro.alexmamo.optimizerealtimedatabase.presentation.product_details.componenta

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import kotlinx.coroutines.InternalCoroutinesApi
import ro.alexmamo.optimizerealtimedatabase.core.Constants.PRODUCT_DETAILS_SCREEN

@Composable
@InternalCoroutinesApi
fun ProductDetailsTopBar(
    navController: NavController
) {
    TopAppBar (
        title = {
            Text(
                text = PRODUCT_DETAILS_SCREEN
            )
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = null,
                )
            }
        }
    )
}