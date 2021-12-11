package ro.alexmamo.optimizerealtimedatabase.presentation.product_names

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
class ProductNamesViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {
    private val _productsState = mutableStateOf<Response<List<Product>>>(Success(emptyList()))
    val productsState: State<Response<List<Product>>> = _productsState

    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            useCases.getProducts().collect { response ->
                _productsState.value = response
            }
        }
    }
}