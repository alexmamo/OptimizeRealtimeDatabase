package ro.alexmamo.optimizerealtimedatabase.domain.repository

import kotlinx.coroutines.flow.Flow
import ro.alexmamo.optimizerealtimedatabase.domain.model.Product
import ro.alexmamo.optimizerealtimedatabase.domain.model.Response

interface ProductListRepository {
    suspend fun getProductListFromRealtimeDatabase(): Flow<Response<List<Product>>>

    suspend fun getProductDetailsFromRealtimeDatabase(productKey: String): Flow<Response<Product>>
}