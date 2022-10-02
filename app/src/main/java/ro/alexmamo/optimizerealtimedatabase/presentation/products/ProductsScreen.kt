package ro.alexmamo.optimizerealtimedatabase.presentation.products

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import ro.alexmamo.optimizerealtimedatabase.components.ProgressBar
import ro.alexmamo.optimizerealtimedatabase.core.Utils.Companion.print
import ro.alexmamo.optimizerealtimedatabase.domain.model.Response.*
import ro.alexmamo.optimizerealtimedatabase.presentation.products.components.ProductsTopBar
import ro.alexmamo.optimizerealtimedatabase.presentation.products.components.ProductsContent

@Composable
@ExperimentalMaterialApi
fun ProductsScreen(
    viewModel: ProductsViewModel = hiltViewModel(),
    navigateToProductScreen: (productKey: String) -> Unit
) {
    Scaffold(
        topBar = {
            ProductsTopBar()
        },
        content = { padding ->
            when(val productsResponse = viewModel.productsResponse) {
                is Loading -> ProgressBar()
                is Success -> ProductsContent(
                    padding = padding,
                    products = productsResponse.data,
                    navigateToProductScreen = navigateToProductScreen
                )
                is Failure -> print(productsResponse.e)
            }
        }
    )
}