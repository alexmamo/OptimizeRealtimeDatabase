package ro.alexmamo.optimizerealtimedatabase.di;

import com.google.firebase.database.DatabaseReference;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class AppModule_ProvideFirebaseDatabaseReferenceFactory implements Factory<DatabaseReference> {
  private final AppModule module;

  public AppModule_ProvideFirebaseDatabaseReferenceFactory(AppModule module) {
    this.module = module;
  }

  @Override
  public DatabaseReference get() {
    return provideFirebaseDatabaseReference(module);
  }

  public static AppModule_ProvideFirebaseDatabaseReferenceFactory create(AppModule module) {
    return new AppModule_ProvideFirebaseDatabaseReferenceFactory(module);
  }

  public static DatabaseReference provideFirebaseDatabaseReference(AppModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideFirebaseDatabaseReference());
  }
}
