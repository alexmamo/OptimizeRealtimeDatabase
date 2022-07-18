package ro.alexmamo.optimizerealtimedatabase.presentation.product_details;

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
public final class ProductDetailsViewModel_Factory implements Factory<ProductDetailsViewModel> {
  private final Provider<UseCases> useCasesProvider;

  public ProductDetailsViewModel_Factory(Provider<UseCases> useCasesProvider) {
    this.useCasesProvider = useCasesProvider;
  }

  @Override
  public ProductDetailsViewModel get() {
    return newInstance(useCasesProvider.get());
  }

  public static ProductDetailsViewModel_Factory create(Provider<UseCases> useCasesProvider) {
    return new ProductDetailsViewModel_Factory(useCasesProvider);
  }

  public static ProductDetailsViewModel newInstance(UseCases useCases) {
    return new ProductDetailsViewModel(useCases);
  }
}
