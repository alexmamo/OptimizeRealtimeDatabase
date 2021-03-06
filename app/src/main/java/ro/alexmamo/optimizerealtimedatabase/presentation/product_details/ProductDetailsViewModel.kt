package ro.alexmamo.optimizerealtimedatabase.presentation.product_details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ro.alexmamo.optimizerealtimedatabase.domain.model.Product
import ro.alexmamo.optimizerealtimedatabase.domain.model.Response
import ro.alexmamo.optimizerealtimedatabase.domain.model.Response.Loading
import ro.alexmamo.optimizerealtimedatabase.domain.use_case.UseCases
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {
    var productDetailsResponse by mutableStateOf<Response<Product>>(Loading)
        private set

    fun getProductDetails(productKey: String) = viewModelScope.launch {
        useCases.getProductDetails(productKey).collect { response ->
            productDetailsResponse = response
        }
    }
}