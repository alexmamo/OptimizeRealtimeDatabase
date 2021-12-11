package ro.alexmamo.optimizerealtimedatabase.di

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import ro.alexmamo.optimizerealtimedatabase.data.repository.ProductsRepositoryImpl
import ro.alexmamo.optimizerealtimedatabase.domain.repository.ProductsRepository
import ro.alexmamo.optimizerealtimedatabase.domain.use_case.GetProductById
import ro.alexmamo.optimizerealtimedatabase.domain.use_case.GetProducts
import ro.alexmamo.optimizerealtimedatabase.domain.use_case.UseCases

@Module
@ExperimentalCoroutinesApi
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideFirebaseDatabaseReference() = FirebaseDatabase.getInstance().reference

    @Provides
    fun provideProductsRepository(
        db: DatabaseReference
    ): ProductsRepository = ProductsRepositoryImpl(db)

    @Provides
    fun provideUseCases(repository: ProductsRepository) = UseCases(
        getProducts = GetProducts(repository = repository),
        getProductById = GetProductById(repository = repository)
    )
}