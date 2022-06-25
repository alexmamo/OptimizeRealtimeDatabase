package ro.alexmamo.optimizerealtimedatabase.presentation.product_details

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
import ro.alexmamo.optimizerealtimedatabase.core.Constants.CM
import ro.alexmamo.optimizerealtimedatabase.core.Constants.DEPTH
import ro.alexmamo.optimizerealtimedatabase.core.Constants.DETAILS
import ro.alexmamo.optimizerealtimedatabase.core.Constants.HEIGHT
import ro.alexmamo.optimizerealtimedatabase.core.Constants.IMAGE_URL
import ro.alexmamo.optimizerealtimedatabase.core.Constants.KG
import ro.alexmamo.optimizerealtimedatabase.core.Constants.NAME
import ro.alexmamo.optimizerealtimedatabase.core.Constants.PRICE
import ro.alexmamo.optimizerealtimedatabase.core.Constants.STOCK
import ro.alexmamo.optimizerealtimedatabase.core.Constants.TAG
import ro.alexmamo.optimizerealtimedatabase.core.Constants.WEIGHT
import ro.alexmamo.optimizerealtimedatabase.core.Constants.WIDTH
import ro.alexmamo.optimizerealtimedatabase.domain.model.Response.*
import ro.alexmamo.optimizerealtimedatabase.presentation.components.ProgressBar
import ro.alexmamo.optimizerealtimedatabase.presentation.product_details.components.ProductDetailsTopBar

@Composable
fun ProductDetailsScreen(
    viewModel: ProductDetailsViewModel = hiltViewModel(),
    productId: String,
    navigateToProductNamesScreen: () -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.getProductById(productId)
    }

    Scaffold(
        topBar = {
            ProductDetailsTopBar(
                navigateToProductNamesScreen = navigateToProductNamesScreen
            )
        },
        content = { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                when(val productResponse = viewModel.productState.value) {
                    is Loading -> ProgressBar()
                    is Success -> {
                        Column(
                            modifier = Modifier.fillMaxSize().padding(top = 8.dp, start = 8.dp)
                        ) {
                            productResponse.data.apply {
                                name?.let {
                                    Text(
                                        text = "$NAME: $name",
                                        fontSize = 24.sp
                                    )
                                }
                                imageUrl?.let {
                                    Text(
                                        text = "$IMAGE_URL: $imageUrl",
                                        fontSize = 24.sp
                                    )
                                }
                                details?.let {
                                    Text(
                                        text = "$DETAILS: $details",
                                        fontSize = 24.sp
                                    )
                                }
                                price?.let {
                                    Text(
                                        text = "$PRICE: $$price",
                                        fontSize = 24.sp
                                    )
                                }
                                stock?.let {
                                    Text(
                                        text = "$STOCK: $stock",
                                        fontSize = 24.sp
                                    )
                                }
                                height?.let {
                                    Text(
                                        text = "$HEIGHT: $height $CM",
                                        fontSize = 24.sp
                                    )
                                }
                                width?.let {
                                    Text(
                                        text = "$WIDTH: $width $CM",
                                        fontSize = 24.sp
                                    )
                                }
                                depth?.let {
                                    Text(
                                        text = "$DEPTH: $depth $CM",
                                        fontSize = 24.sp
                                    )
                                }
                                weight?.let {
                                    Text(
                                        text = "$WEIGHT: $weight $KG",
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
    )
}