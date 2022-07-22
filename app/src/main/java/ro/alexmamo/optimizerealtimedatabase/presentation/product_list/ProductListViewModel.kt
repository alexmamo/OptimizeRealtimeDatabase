package ro.alexmamo.optimizerealtimedatabase.presentation.product_list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ro.alexmamo.optimizerealtimedatabase.domain.model.Product
import ro.alexmamo.optimizerealtimedatabase.domain.model.Response
import ro.alexmamo.optimizerealtimedatabase.domain.model.Response.*
import ro.alexmamo.optimizerealtimedatabase.domain.use_case.UseCases
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {
    var productListResponse by mutableStateOf<Response<List<Product>>>(Loading)
        private set

    init {
        getProductList()
    }

    private fun getProductList() = viewModelScope.launch {
        useCases.getProductList().collect { response ->
            productListResponse = response
        }
    }
}