package ro.alexmamo.optimizerealtimedatabase.domain.repository

import ro.alexmamo.optimizerealtimedatabase.domain.model.Product
import ro.alexmamo.optimizerealtimedatabase.domain.model.Response

typealias Products = List<Product>
typealias ProductsResponse = Response<Products>
typealias ProductResponse = Response<Product>

interface ProductsRepository {
    suspend fun getProductsFromRealtimeDatabase(): ProductsResponse

    suspend fun getProductFromRealtimeDatabase(productKey: String): ProductResponse
}