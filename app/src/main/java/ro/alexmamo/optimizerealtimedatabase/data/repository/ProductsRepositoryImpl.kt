package ro.alexmamo.optimizerealtimedatabase.data.repository

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import kotlinx.coroutines.tasks.await
import ro.alexmamo.optimizerealtimedatabase.core.Constants.PRODUCTS
import ro.alexmamo.optimizerealtimedatabase.core.Constants.PRODUCT_NAMES
import ro.alexmamo.optimizerealtimedatabase.domain.model.Product
import ro.alexmamo.optimizerealtimedatabase.domain.model.Response.Failure
import ro.alexmamo.optimizerealtimedatabase.domain.model.Response.Success
import ro.alexmamo.optimizerealtimedatabase.domain.repository.ProductResponse
import ro.alexmamo.optimizerealtimedatabase.domain.repository.ProductsRepository
import ro.alexmamo.optimizerealtimedatabase.domain.repository.ProductsResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductsRepositoryImpl @Inject constructor(
    private val db: DatabaseReference
): ProductsRepository {
    override suspend fun getProductsFromRealtimeDatabase(): ProductsResponse = try {
            val products = mutableListOf<Product>()
            db.child(PRODUCT_NAMES).get().await().children.forEach { snapshot ->
                val product = snapshot.toProduct()
                products.add(product)
            }
            Success(products)
        } catch (e: Exception) {
            Failure(e)
        }

    override suspend fun getProductFromRealtimeDatabase(productKey: String): ProductResponse = try {
        val productKeyRef = db.child(PRODUCTS).child(productKey)
        val product = productKeyRef.get().await().getValue(Product::class.java)
        Success(product)
    } catch (e: Exception) {
        Failure(e)
    }
}

fun DataSnapshot.toProduct() = Product(
    key = key,
    name = getValue(String::class.java)
)