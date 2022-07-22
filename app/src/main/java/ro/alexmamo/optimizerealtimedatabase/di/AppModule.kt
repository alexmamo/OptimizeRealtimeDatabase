package ro.alexmamo.optimizerealtimedatabase.di

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ro.alexmamo.optimizerealtimedatabase.data.repository.ProductListRepositoryImpl
import ro.alexmamo.optimizerealtimedatabase.domain.repository.ProductListRepository
import ro.alexmamo.optimizerealtimedatabase.domain.use_case.GetProductDetails
import ro.alexmamo.optimizerealtimedatabase.domain.use_case.GetProductList
import ro.alexmamo.optimizerealtimedatabase.domain.use_case.UseCases

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideFirebaseDatabaseReference() = Firebase.database.reference

    @Provides
    fun provideProductListRepository(
        db: DatabaseReference
    ): ProductListRepository = ProductListRepositoryImpl(db)

    @Provides
    fun provideUseCases(
        repo: ProductListRepository
    ) = UseCases(
        getProductList = GetProductList(repo = repo),
        getProductDetails = GetProductDetails(repo = repo)
    )
}