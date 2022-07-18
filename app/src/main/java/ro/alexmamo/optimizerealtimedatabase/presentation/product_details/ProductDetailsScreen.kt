package ro.alexmamo.optimizerealtimedatabase.presentation.product_details

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import ro.alexmamo.optimizerealtimedatabase.presentation.product_details.components.ProductDetailsContent
import ro.alexmamo.optimizerealtimedatabase.presentation.product_details.components.ProductDetailsTopBar

@Composable
fun ProductDetailsScreen(
    productKey: String,
    navigateToProductNamesScreen: () -> Unit
) {
    Scaffold(
        topBar = {
            ProductDetailsTopBar(
                navigateToProductNamesScreen = navigateToProductNamesScreen
            )
        },
        content = { padding ->
            ProductDetailsContent(
                padding = padding,
                productId = productKey
            )
        }
    )
}