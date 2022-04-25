package ro.alexmamo.optimizerealtimedatabase.presentation.product_details

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import ro.alexmamo.optimizerealtimedatabase.core.Constants.TAG
import ro.alexmamo.optimizerealtimedatabase.domain.model.Response.*
import ro.alexmamo.optimizerealtimedatabase.presentation.components.ProgressBar
import ro.alexmamo.optimizerealtimedatabase.presentation.product_details.components.ProductDetailsTopBar

@Composable
@InternalCoroutinesApi
@ExperimentalCoroutinesApi
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
fun ProductDetailsScreen(
    navController: NavController,
    productId: String,
    viewModel: ProductDetailsViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.getProductById(productId)
    }
    Scaffold(
        topBar = {
            ProductDetailsTopBar(navController)
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 8.dp, start = 8.dp)
        ) {
            when(val productResponse = viewModel.productState.value) {
                is Loading -> ProgressBar()
                is Success -> {
                    Column {
                        productResponse.data.apply {
                            name?.let {
                                Text(
                                    text = "name: $name",
                                    fontSize = 24.sp
                                )
                            }
                            imageUrl?.let {
                                Text(
                                    text = "imageUrl: $imageUrl",
                                    fontSize = 24.sp
                                )
                            }
                            details?.let {
                                Text(
                                    text = "details: $details",
                                    fontSize = 24.sp
                                )
                            }
                            price?.let {
                                Text(
                                    text = "price: $$price",
                                    fontSize = 24.sp
                                )
                            }
                            stock?.let {
                                Text(
                                    text = "stock: $stock",
                                    fontSize = 24.sp
                                )
                            }
                            height?.let {
                                Text(
                                    text = "height: $height cm",
                                    fontSize = 24.sp
                                )
                            }
                            width?.let {
                                Text(
                                    text = "width: $width cm",
                                    fontSize = 24.sp
                                )
                            }
                            depth?.let {
                                Text(
                                    text = "depth: $depth cm",
                                    fontSize = 24.sp
                                )
                            }
                            weight?.let {
                                Text(
                                    text = "weight: $weight Kg",
                                    fontSize = 24.sp
                                )
                            }
                        }
                    }

                }
                is Error -> Log.d(TAG, productResponse.message)
            }
        }
    }
}