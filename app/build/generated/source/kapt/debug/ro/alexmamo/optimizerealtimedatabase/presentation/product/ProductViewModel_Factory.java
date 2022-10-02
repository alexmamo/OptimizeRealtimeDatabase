package ro.alexmamo.optimizerealtimedatabase.presentation.product;

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
public final class ProductViewModel_Factory implements Factory<ProductViewModel> {
  private final Provider<UseCases> useCasesProvider;

  public ProductViewModel_Factory(Provider<UseCases> useCasesProvider) {
    this.useCasesProvider = useCasesProvider;
  }

  @Override
  public ProductViewModel get() {
    return newInstance(useCasesProvider.get());
  }

  public static ProductViewModel_Factory create(Provider<UseCases> useCasesProvider) {
    return new ProductViewModel_Factory(useCasesProvider);
  }

  public static ProductViewModel newInstance(UseCases useCases) {
    return new ProductViewModel(useCases);
  }
}
