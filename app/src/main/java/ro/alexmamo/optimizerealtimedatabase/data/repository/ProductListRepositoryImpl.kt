package ro.alexmamo.optimizerealtimedatabase.data.repository

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import ro.alexmamo.optimizerealtimedatabase.core.Constants.PRODUCTS
import ro.alexmamo.optimizerealtimedatabase.core.Constants.PRODUCT_NAMES
import ro.alexmamo.optimizerealtimedatabase.domain.model.Product
import ro.alexmamo.optimizerealtimedatabase.domain.model.Response.*
import ro.alexmamo.optimizerealtimedatabase.domain.repository.ProductListRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductListRepositoryImpl @Inject constructor(
    private val db: DatabaseReference
): ProductListRepository {
    override fun getProductListFromRealtimeDatabase()  = flow {
        try {
            emit(Loading)
            val products = mutableListOf<Product>()
            db.child(PRODUCT_NAMES).get().await().children.forEach { snapshot ->
                val product = snapshot.toProduct()
                products.add(product)
            }
            emit(Success(products))
        } catch (e: Exception) {
            emit(Error(e))
        }
    }

    override fun getProductDetailsFromRealtimeDatabase(productKey: String) = flow {
        try {
            emit(Loading)
            val productKeyRef = db.child(PRODUCTS).child(productKey)
            val product = productKeyRef.get().await().getValue(Product::class.java)
            product?.let {
                emit(Success(product))
            }
        } catch (e: Exception) {
            emit(Error(e))
        }
    }
}

fun DataSnapshot.toProduct() = Product(
    key = key,
    name = getValue(String::class.java)
)