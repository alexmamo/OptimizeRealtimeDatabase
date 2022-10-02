package ro.alexmamo.optimizerealtimedatabase.domain.use_case

import ro.alexmamo.optimizerealtimedatabase.domain.repository.ProductsRepository

class GetProducts(
    private val repo: ProductsRepository
) {
    suspend operator fun invoke() = repo.getProductsFromRealtimeDatabase()
}