package ro.alexmamo.optimizerealtimedatabase.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import ro.alexmamo.optimizerealtimedatabase.domain.repository.ProductListRepository;
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
public final class AppModule_ProvideUseCasesFactory implements Factory<UseCases> {
  private final AppModule module;

  private final Provider<ProductListRepository> repoProvider;

  public AppModule_ProvideUseCasesFactory(AppModule module,
      Provider<ProductListRepository> repoProvider) {
    this.module = module;
    this.repoProvider = repoProvider;
  }

  @Override
  public UseCases get() {
    return provideUseCases(module, repoProvider.get());
  }

  public static AppModule_ProvideUseCasesFactory create(AppModule module,
      Provider<ProductListRepository> repoProvider) {
    return new AppModule_ProvideUseCasesFactory(module, repoProvider);
  }

  public static UseCases provideUseCases(AppModule instance, ProductListRepository repo) {
    return Preconditions.checkNotNullFromProvides(instance.provideUseCases(repo));
  }
}
