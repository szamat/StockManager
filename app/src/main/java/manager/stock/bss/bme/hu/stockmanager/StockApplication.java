package manager.stock.bss.bme.hu.stockmanager;

import android.app.Application;

import javax.inject.Inject;

import manager.stock.bss.bme.hu.stockmanager.repository.ToolRepository;
import manager.stock.bss.bme.hu.stockmanager.ui.UIModule;

public class StockApplication extends Application{
    public static StockApplicationComponent injector;

    @Inject
    ToolRepository repository;

    public void setInjector(StockApplicationComponent appComponent) {
        injector = appComponent;
        injector.inject(this);
        repository.open(getApplicationContext());
    }

    @Override
    public void onCreate() {
        super.onCreate();


        injector =
                DaggerStockApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();

        injector.inject(this);
        repository.open(getApplicationContext());
    }
}
