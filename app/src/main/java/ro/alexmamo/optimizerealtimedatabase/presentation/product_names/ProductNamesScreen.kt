package ro.alexmamo.optimizerealtimedatabase.presentation.product_names

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import ro.alexmamo.optimizerealtimedatabase.presentation.product_names.components.ProductNamesContent
import ro.alexmamo.optimizerealtimedatabase.presentation.product_names.components.ProductNamesTopBar

@Composable
fun ProductNamesScreen(
    navigateToProductDetails: (productKey: String) -> Unit
) {
    Scaffold(
        topBar = {
            ProductNamesTopBar()
        },
        content = { padding ->
            ProductNamesContent(
                padding = padding,
                navigateToProductDetails = navigateToProductDetails
            )
        }
    )
}