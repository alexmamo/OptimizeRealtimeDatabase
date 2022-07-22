package ro.alexmamo.optimizerealtimedatabase.di;

import com.google.firebase.database.DatabaseReference;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import ro.alexmamo.optimizerealtimedatabase.domain.repository.ProductListRepository;

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
public final class AppModule_ProvideProductListRepositoryFactory implements Factory<ProductListRepository> {
  private final AppModule module;

  private final Provider<DatabaseReference> dbProvider;

  public AppModule_ProvideProductListRepositoryFactory(AppModule module,
      Provider<DatabaseReference> dbProvider) {
    this.module = module;
    this.dbProvider = dbProvider;
  }

  @Override
  public ProductListRepository get() {
    return provideProductListRepository(module, dbProvider.get());
  }

  public static AppModule_ProvideProductListRepositoryFactory create(AppModule module,
      Provider<DatabaseReference> dbProvider) {
    return new AppModule_ProvideProductListRepositoryFactory(module, dbProvider);
  }

  public static ProductListRepository provideProductListRepository(AppModule instance,
      DatabaseReference db) {
    return Preconditions.checkNotNullFromProvides(instance.provideProductListRepository(db));
  }
}
