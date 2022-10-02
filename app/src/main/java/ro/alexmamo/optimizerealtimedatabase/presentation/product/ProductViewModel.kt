package ro.alexmamo.optimizerealtimedatabase.presentation.product

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ro.alexmamo.optimizerealtimedatabase.domain.model.Response.Loading
import ro.alexmamo.optimizerealtimedatabase.domain.repository.ProductResponse
import ro.alexmamo.optimizerealtimedatabase.domain.use_case.UseCases
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {
    var productResponse by mutableStateOf<ProductResponse>(Loading)
        private set

    fun getProduct(productKey: String) = viewModelScope.launch {
        productResponse = Loading
        productResponse = useCases.getProduct(productKey)
    }
}