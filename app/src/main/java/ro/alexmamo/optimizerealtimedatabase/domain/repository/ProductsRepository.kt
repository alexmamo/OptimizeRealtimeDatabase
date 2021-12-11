package ro.alexmamo.optimizerealtimedatabase.domain.repository

import kotlinx.coroutines.flow.Flow
import ro.alexmamo.optimizerealtimedatabase.domain.model.Product
import ro.alexmamo.optimizerealtimedatabase.domain.model.Response

interface ProductsRepository {
    suspend fun getProducts(): Flow<Response<List<Product>>>

    suspend fun getProductById(id: String): Flow<Response<Product>>
}