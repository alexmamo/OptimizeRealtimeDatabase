package ro.alexmamo.optimizerealtimedatabase.di;

import com.google.firebase.database.DatabaseReference;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import ro.alexmamo.optimizerealtimedatabase.domain.repository.ProductsRepository;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppModule_ProvideProductsRepositoryFactory implements Factory<ProductsRepository> {
  private final AppModule module;

  private final Provider<DatabaseReference> dbProvider;

  public AppModule_ProvideProductsRepositoryFactory(AppModule module,
      Provider<DatabaseReference> dbProvider) {
    this.module = module;
    this.dbProvider = dbProvider;
  }

  @Override
  public ProductsRepository get() {
    return provideProductsRepository(module, dbProvider.get());
  }

  public static AppModule_ProvideProductsRepositoryFactory create(AppModule module,
      Provider<DatabaseReference> dbProvider) {
    return new AppModule_ProvideProductsRepositoryFactory(module, dbProvider);
  }

  public static ProductsRepository provideProductsRepository(AppModule instance,
      DatabaseReference db) {
    return Preconditions.checkNotNullFromProvides(instance.provideProductsRepository(db));
  }
}
