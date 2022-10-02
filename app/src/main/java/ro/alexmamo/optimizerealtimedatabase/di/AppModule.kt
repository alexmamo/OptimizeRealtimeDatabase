package ro.alexmamo.optimizerealtimedatabase.di

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ro.alexmamo.optimizerealtimedatabase.data.repository.ProductsRepositoryImpl
import ro.alexmamo.optimizerealtimedatabase.domain.repository.ProductsRepository
import ro.alexmamo.optimizerealtimedatabase.domain.use_case.GetProduct
import ro.alexmamo.optimizerealtimedatabase.domain.use_case.GetProducts
import ro.alexmamo.optimizerealtimedatabase.domain.use_case.UseCases

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideFirebaseDatabaseReference() = Firebase.database.reference

    @Provides
    fun provideProductsRepository(
        db: DatabaseReference
    ): ProductsRepository = ProductsRepositoryImpl(db)

    @Provides
    fun provideUseCases(
        repo: ProductsRepository
    ) = UseCases(
        getProducts = GetProducts(repo = repo),
        getProduct = GetProduct(repo = repo)
    )
}