package manager.stock.bss.bme.hu.stockmanager;

import android.app.Application;

import manager.stock.bss.bme.hu.stockmanager.ui.UIModule;

public class StockApplication extends Application{
    public static StockApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector =
                DaggerStockApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();
    }
}
