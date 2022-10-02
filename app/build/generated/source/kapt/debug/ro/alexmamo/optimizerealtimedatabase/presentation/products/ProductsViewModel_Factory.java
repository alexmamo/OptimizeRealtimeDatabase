package ro.alexmamo.optimizerealtimedatabase.presentation.products;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import ro.alexmamo.optimizerealtimedatabase.domain.use_case.UseCases;

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
public final class ProductsViewModel_Factory implements Factory<ProductsViewModel> {
  private final Provider<UseCases> useCasesProvider;

  public ProductsViewModel_Factory(Provider<UseCases> useCasesProvider) {
    this.useCasesProvider = useCasesProvider;
  }

  @Override
  public ProductsViewModel get() {
    return newInstance(useCasesProvider.get());
  }

  public static ProductsViewModel_Factory create(Provider<UseCases> useCasesProvider) {
    return new ProductsViewModel_Factory(useCasesProvider);
  }

  public static ProductsViewModel newInstance(UseCases useCases) {
    return new ProductsViewModel(useCases);
  }
}
