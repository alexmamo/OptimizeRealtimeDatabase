package ro.alexmamo.optimizerealtimedatabase.presentation.product_names;

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
public final class ProductNamesViewModel_Factory implements Factory<ProductNamesViewModel> {
  private final Provider<UseCases> useCasesProvider;

  public ProductNamesViewModel_Factory(Provider<UseCases> useCasesProvider) {
    this.useCasesProvider = useCasesProvider;
  }

  @Override
  public ProductNamesViewModel get() {
    return newInstance(useCasesProvider.get());
  }

  public static ProductNamesViewModel_Factory create(Provider<UseCases> useCasesProvider) {
    return new ProductNamesViewModel_Factory(useCasesProvider);
  }

  public static ProductNamesViewModel newInstance(UseCases useCases) {
    return new ProductNamesViewModel(useCases);
  }
}
