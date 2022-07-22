package ro.alexmamo.optimizerealtimedatabase.domain.use_case

import ro.alexmamo.optimizerealtimedatabase.domain.repository.ProductListRepository

class GetProductDetails(
    private val repo: ProductListRepository
) {
    suspend operator fun invoke(
        productKey: String
    ) = repo.getProductDetailsFromRealtimeDatabase(productKey)
}