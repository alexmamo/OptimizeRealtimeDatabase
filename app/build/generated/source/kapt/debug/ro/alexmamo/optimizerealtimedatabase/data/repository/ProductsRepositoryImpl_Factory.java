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
public final class ProductsRepositoryImpl_Factory implements Factory<ProductsRepositoryImpl> {
  private final Provider<DatabaseReference> dbProvider;

  public ProductsRepositoryImpl_Factory(Provider<DatabaseReference> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public ProductsRepositoryImpl get() {
    return newInstance(dbProvider.get());
  }

  public static ProductsRepositoryImpl_Factory create(Provider<DatabaseReference> dbProvider) {
    return new ProductsRepositoryImpl_Factory(dbProvider);
  }

  public static ProductsRepositoryImpl newInstance(DatabaseReference db) {
    return new ProductsRepositoryImpl(db);
  }
}
