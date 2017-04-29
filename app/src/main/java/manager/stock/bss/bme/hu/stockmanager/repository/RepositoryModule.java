package manager.stock.bss.bme.hu.stockmanager.repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Singleton
    @Provides
    public ToolRepository provideRepository() {
        return new ToolRepositorySugar();
    }
}
