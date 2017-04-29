package manager.stock.bss.bme.hu.stockmanager.ui.main;

import android.util.Log;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import manager.stock.bss.bme.hu.stockmanager.interactor.tool.ToolInteractor;
import manager.stock.bss.bme.hu.stockmanager.interactor.tool.event.GetToolsEvent;
import manager.stock.bss.bme.hu.stockmanager.ui.Presenter;

import static manager.stock.bss.bme.hu.stockmanager.StockApplication.injector;

public class MainPresenter extends Presenter<MainScreen>{


    @Inject
    ToolInteractor toolInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public MainPresenter() {
    }

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);

        getTools();

        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void getTools() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                toolInteractor.getTools();
            }
        });
    }


    public void onEventMainThread(GetToolsEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading favourites", event.getThrowable());
        } else {
            screen.loadToolList(event.getTools());

        }
    }


}
