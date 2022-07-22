package ro.alexmamo.optimizerealtimedatabase.presentation.product_list

import android.util.Log
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import ro.alexmamo.optimizerealtimedatabase.components.ProgressBar
import ro.alexmamo.optimizerealtimedatabase.core.Constants.TAG
import ro.alexmamo.optimizerealtimedatabase.domain.model.Response.*
import ro.alexmamo.optimizerealtimedatabase.presentation.product_list.components.ProductListContent
import ro.alexmamo.optimizerealtimedatabase.presentation.product_list.components.ProductListTopBar

@Composable
@ExperimentalMaterialApi
fun ProductListScreen(
    viewModel: ProductListViewModel = hiltViewModel(),
    navigateToProductDetails: (productKey: String) -> Unit
) {
    Scaffold(
        topBar = {
            ProductListTopBar()
        },
        content = { padding ->
            when(val productListResponse = viewModel.productListResponse) {
                is Loading -> ProgressBar()
                is Success -> ProductListContent(
                    padding = padding,
                    productList = productListResponse.data,
                    navigateToProductDetails = navigateToProductDetails
                )
                is Error -> Log.d(TAG, productListResponse.message)
            }
        }
    )
}