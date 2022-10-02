package ro.alexmamo.optimizerealtimedatabase.presentation.products

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ro.alexmamo.optimizerealtimedatabase.domain.model.Response.Loading
import ro.alexmamo.optimizerealtimedatabase.domain.repository.ProductsResponse
import ro.alexmamo.optimizerealtimedatabase.domain.use_case.UseCases
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {
    var productsResponse by mutableStateOf<ProductsResponse>(Loading)
        private set

    init {
        getProducts()
    }

    private fun getProducts() = viewModelScope.launch {
        productsResponse = Loading
        productsResponse = useCases.getProducts()
    }
}