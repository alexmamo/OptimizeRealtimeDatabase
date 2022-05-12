package ro.alexmamo.optimizerealtimedatabase.data.repository

import com.google.firebase.database.DatabaseReference
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import ro.alexmamo.optimizerealtimedatabase.core.Constants.PRODUCTS
import ro.alexmamo.optimizerealtimedatabase.core.Constants.PRODUCT_NAMES
import ro.alexmamo.optimizerealtimedatabase.domain.model.Product
import ro.alexmamo.optimizerealtimedatabase.domain.model.Response.*
import ro.alexmamo.optimizerealtimedatabase.domain.repository.ProductsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductsRepositoryImpl @Inject constructor(
    private val db: DatabaseReference
): ProductsRepository {
    override suspend fun getProducts()  = flow {
        try {
            emit(Loading)
            val products = mutableListOf<Product>()
            db.child(PRODUCT_NAMES).get().await().children.forEach { snapshot ->
                products.add(
                    Product(
                        key = snapshot.key,
                        name = snapshot.getValue(String::class.java)
                    )
                )
            }
            emit(Success(products))
        } catch (e: Exception) {
            emit(Error(e.message ?: e.toString()))
        }
    }

    override suspend fun getProductById(id: String) = flow {
        try {
            emit(Loading)
            val product = db.child(PRODUCTS).child(id).get().await().getValue(Product::class.java)
            product?.let {
                emit(Success(product))
            }
        } catch (e: Exception) {
            emit(Error(e.message ?: e.toString()))
        }
    }
}