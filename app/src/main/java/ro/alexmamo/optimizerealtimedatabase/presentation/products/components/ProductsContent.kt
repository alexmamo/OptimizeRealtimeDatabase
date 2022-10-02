package ro.alexmamo.optimizerealtimedatabase.presentation.products.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ro.alexmamo.optimizerealtimedatabase.domain.repository.Products

@Composable
@ExperimentalMaterialApi
fun ProductsContent(
    padding: PaddingValues,
    products: Products?,
    navigateToProductScreen: (productKey: String) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(padding)
    ) {
        products?.let {
            items(
                items = products
            ) { product ->
                ProductCard(
                    product = product,
                    onClick = {
                        product.key?.let { productKey ->
                            navigateToProductScreen(productKey)
                        }
                    }
                )
            }
        }
    }
}