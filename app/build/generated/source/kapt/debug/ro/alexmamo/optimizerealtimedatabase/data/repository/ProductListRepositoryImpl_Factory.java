package ro.alexmamo.optimizerealtimedatabase.data.repository;

import com.google.firebase.database.DatabaseReference;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class ProductListRepositoryImpl_Factory implements Factory<ProductListRepositoryImpl> {
  private final Provider<DatabaseReference> dbProvider;

  public ProductListRepositoryImpl_Factory(Provider<DatabaseReference> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public ProductListRepositoryImpl get() {
    return newInstance(dbProvider.get());
  }

  public static ProductListRepositoryImpl_Factory create(Provider<DatabaseReference> dbProvider) {
    return new ProductListRepositoryImpl_Factory(dbProvider);
  }

  public static ProductListRepositoryImpl newInstance(DatabaseReference db) {
    return new ProductListRepositoryImpl(db);
  }
}
