package manager.stock.bss.bme.hu.stockmanager;

import javax.inject.Singleton;

import dagger.Component;
import manager.stock.bss.bme.hu.stockmanager.interactor.InteractorModule;
import manager.stock.bss.bme.hu.stockmanager.mock.MockNetworkModule;
import manager.stock.bss.bme.hu.stockmanager.repository.TestRepositoryModule;


@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class, InteractorModule.class, TestRepositoryModule.class})
public interface TestComponent extends StockApplicationComponent {
}
