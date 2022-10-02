package ro.alexmamo.optimizerealtimedatabase.presentation.products.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ro.alexmamo.optimizerealtimedatabase.core.Constants.NO_VALUE
import ro.alexmamo.optimizerealtimedatabase.domain.model.Product

@Composable
@ExperimentalMaterialApi
fun ProductCard(
    product: Product,
    onClick: () -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier.fillMaxWidth()
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 4.dp,
                bottom = 4.dp
            ),
        elevation = 3.dp,
        onClick = onClick
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
                .padding(
                    all = 12.dp
                )
        ) {
            val productName = product.name ?: NO_VALUE
            Text(
                text = productName,
                color = Color.DarkGray,
                fontSize = 25.sp
            )
        }
    }
}