package ro.alexmamo.optimizerealtimedatabase.presentation.product_names

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ro.alexmamo.optimizerealtimedatabase.core.Constants.TAG
import ro.alexmamo.optimizerealtimedatabase.domain.model.Response.*
import ro.alexmamo.optimizerealtimedatabase.presentation.components.ProgressBar
import ro.alexmamo.optimizerealtimedatabase.presentation.navigation.Screen.ProductDetailsScreen
import ro.alexmamo.optimizerealtimedatabase.presentation.product_names.components.ProductNameCard
import ro.alexmamo.optimizerealtimedatabase.presentation.product_names.components.ProductNamesTopBar

@Composable
fun ProductNamesScreen(
    navController: NavController,
    viewModel: ProductNamesViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            ProductNamesTopBar()
        },
        content = { padding ->
            when(val productsResponse = viewModel.productsState.value) {
                is Loading -> ProgressBar()
                is Success -> LazyColumn(
                    modifier = Modifier.fillMaxSize().padding(padding)
                ) {
                    items(
                        items = productsResponse.data
                    ) { product ->
                        ProductNameCard(
                            product = product,
                            onProductClick = {
                                navController.navigate(ProductDetailsScreen.route + "/${product.key}")
                            }
                        )
                    }
                }
                is Error -> Log.d(TAG, productsResponse.message)
            }
        }
    )
}