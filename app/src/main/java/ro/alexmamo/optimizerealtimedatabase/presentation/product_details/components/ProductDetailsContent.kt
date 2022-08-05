package ro.alexmamo.optimizerealtimedatabase.presentation.product_details.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import ro.alexmamo.optimizerealtimedatabase.components.ProgressBar
import ro.alexmamo.optimizerealtimedatabase.core.Constants.CM
import ro.alexmamo.optimizerealtimedatabase.core.Constants.DEPTH
import ro.alexmamo.optimizerealtimedatabase.core.Constants.DETAILS
import ro.alexmamo.optimizerealtimedatabase.core.Constants.HEIGHT
import ro.alexmamo.optimizerealtimedatabase.core.Constants.IMAGE_URL
import ro.alexmamo.optimizerealtimedatabase.core.Constants.KG
import ro.alexmamo.optimizerealtimedatabase.core.Constants.NAME
import ro.alexmamo.optimizerealtimedatabase.core.Constants.PRICE
import ro.alexmamo.optimizerealtimedatabase.core.Constants.STOCK
import ro.alexmamo.optimizerealtimedatabase.core.Constants.WEIGHT
import ro.alexmamo.optimizerealtimedatabase.core.Constants.WIDTH
import ro.alexmamo.optimizerealtimedatabase.core.Utils.Companion.print
import ro.alexmamo.optimizerealtimedatabase.domain.model.Response.*
import ro.alexmamo.optimizerealtimedatabase.presentation.product_details.ProductDetailsViewModel

@Composable
fun ProductDetailsContent(
    padding: PaddingValues,
    viewModel: ProductDetailsViewModel = hiltViewModel(),
    productKey: String,
) {
    LaunchedEffect(Unit) {
        viewModel.getProductDetails(productKey)
    }

    Box(
        modifier = Modifier.fillMaxSize().padding(padding)
    ) {
        when(val productDetailsResponse = viewModel.productDetailsResponse) {
            is Loading -> ProgressBar()
            is Success -> Column(
                modifier = Modifier.fillMaxSize().padding(
                    top = 8.dp,
                    start = 8.dp
                )
            ) {
                productDetailsResponse.data.apply {
                    name?.let {
                        Text(
                            text = "${NAME}: $name",
                            fontSize = 24.sp
                        )
                    }
                    imageUrl?.let {
                        Text(
                            text = "${IMAGE_URL}: $imageUrl",
                            fontSize = 24.sp
                        )
                    }
                    details?.let {
                        Text(
                            text = "${DETAILS}: $details",
                            fontSize = 24.sp
                        )
                    }
                    price?.let {
                        Text(
                            text = "${PRICE}: $$price",
                            fontSize = 24.sp
                        )
                    }
                    stock?.let {
                        Text(
                            text = "${STOCK}: $stock",
                            fontSize = 24.sp
                        )
                    }
                    height?.let {
                        Text(
                            text = "${HEIGHT}: $height $CM",
                            fontSize = 24.sp
                        )
                    }
                    width?.let {
                        Text(
                            text = "${WIDTH}: $width $CM",
                            fontSize = 24.sp
                        )
                    }
                    depth?.let {
                        Text(
                            text = "${DEPTH}: $depth $CM",
                            fontSize = 24.sp
                        )
                    }
                    weight?.let {
                        Text(
                            text = "${WEIGHT}: $weight $KG",
                            fontSize = 24.sp
                        )
                    }
                }
            }
            is Error -> print(productDetailsResponse.e)
        }
    }
}