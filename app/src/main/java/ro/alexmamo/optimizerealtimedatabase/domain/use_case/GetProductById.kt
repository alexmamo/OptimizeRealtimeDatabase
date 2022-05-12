package ro.alexmamo.optimizerealtimedatabase.domain.use_case

import ro.alexmamo.optimizerealtimedatabase.domain.repository.ProductsRepository

class GetProductById(
    private val repo: ProductsRepository
) {
    suspend operator fun invoke(id: String) = repo.getProductById(id)
}