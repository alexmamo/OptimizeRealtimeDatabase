package ro.alexmamo.optimizerealtimedatabase.domain.use_case

import ro.alexmamo.optimizerealtimedatabase.domain.repository.ProductsRepository

class GetProduct(
    private val repo: ProductsRepository
) {
    suspend operator fun invoke(
        productKey: String
    ) = repo.getProductFromRealtimeDatabase(productKey)
}