package ro.alexmamo.optimizerealtimedatabase.presentation.product_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ro.alexmamo.optimizerealtimedatabase.domain.model.Product
import ro.alexmamo.optimizerealtimedatabase.domain.model.Response
import ro.alexmamo.optimizerealtimedatabase.domain.model.Response.Success
import ro.alexmamo.optimizerealtimedatabase.domain.use_case.UseCases
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {
    private val _productState = mutableStateOf<Response<Product>>(Success(Product()))
    val productState: State<Response<Product>> = _productState

    fun getProductById(id: String) = viewModelScope.launch {
        useCases.getProductById(id).collect { response ->
            _productState.value = response
        }
    }
}