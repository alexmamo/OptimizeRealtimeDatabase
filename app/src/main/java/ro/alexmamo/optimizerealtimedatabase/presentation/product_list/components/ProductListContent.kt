package ro.alexmamo.optimizerealtimedatabase.presentation.product_list.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ro.alexmamo.optimizerealtimedatabase.domain.model.Product

@Composable
@ExperimentalMaterialApi
fun ProductListContent(
    padding: PaddingValues,
    productList: List<Product>,
    navigateToProductDetails: (productKey: String) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(padding)
    ) {
        items(
            items = productList
        ) { product ->
            ProductCard(
                product = product,
                onClick = {
                    product.key?.let { productKey ->
                        navigateToProductDetails(productKey)
                    }
                }
            )
        }
    }
}