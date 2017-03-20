package manager.stock.bss.bme.hu.stockmanager;

import javax.inject.Singleton;

import dagger.Component;
import manager.stock.bss.bme.hu.stockmanager.ui.UIModule;
import manager.stock.bss.bme.hu.stockmanager.ui.main.MainActivity;

@Singleton
@Component(modules = {UIModule.class})
public interface StockApplicationComponent {
    void inject(MainActivity mainActivity);
}
