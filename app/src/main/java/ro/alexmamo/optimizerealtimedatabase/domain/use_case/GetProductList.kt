package ro.alexmamo.optimizerealtimedatabase.domain.use_case

import ro.alexmamo.optimizerealtimedatabase.domain.repository.ProductListRepository

class GetProductList(
    private val repo: ProductListRepository
) {
    suspend operator fun invoke() = repo.getProductListFromRealtimeDatabase()
}