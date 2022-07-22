package ro.alexmamo.optimizerealtimedatabase.presentation.product_list;

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
public final class ProductListViewModel_Factory implements Factory<ProductListViewModel> {
  private final Provider<UseCases> useCasesProvider;

  public ProductListViewModel_Factory(Provider<UseCases> useCasesProvider) {
    this.useCasesProvider = useCasesProvider;
  }

  @Override
  public ProductListViewModel get() {
    return newInstance(useCasesProvider.get());
  }

  public static ProductListViewModel_Factory create(Provider<UseCases> useCasesProvider) {
    return new ProductListViewModel_Factory(useCasesProvider);
  }

  public static ProductListViewModel newInstance(UseCases useCases) {
    return new ProductListViewModel(useCases);
  }
}
