package ro.alexmamo.optimizerealtimedatabase.presentation.product_details

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import ro.alexmamo.optimizerealtimedatabase.presentation.product_details.components.ProductDetailsContent
import ro.alexmamo.optimizerealtimedatabase.presentation.product_details.components.ProductDetailsTopBar

@Composable
fun ProductDetailsScreen(
    productKey: String,
    navigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            ProductDetailsTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            ProductDetailsContent(
                padding = padding,
                productKey = productKey
            )
        }
    )
}