package manager.stock.bss.bme.hu.stockmanager.ui.Sync;

import android.util.Log;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import manager.stock.bss.bme.hu.stockmanager.interactor.tool.ToolInteractor;
import manager.stock.bss.bme.hu.stockmanager.interactor.tool.event.GetToolsEvent;
import manager.stock.bss.bme.hu.stockmanager.interactor.tool.event.SaveToolEvent;
import manager.stock.bss.bme.hu.stockmanager.interactor.tool.event.SyncEvent;
import manager.stock.bss.bme.hu.stockmanager.ui.Presenter;

import static manager.stock.bss.bme.hu.stockmanager.StockApplication.injector;

public class SyncPresenter extends Presenter<SyncScreen> {

    @Inject
    ToolInteractor toolInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public SyncPresenter() {
    }

    public void getTools() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                toolInteractor.getTools();
            }
        });
    }

    public void doSync(final String username, final String password){
        executor.execute(new Runnable(){
            @Override
            public void run(){
                toolInteractor.doSync(username,password);
            }
        });
    }

    @Override
    public void attachScreen(SyncScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        bus.unregister(this);
    }

    public void onEventMainThread(GetToolsEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {

            }
            Log.e("Networking", "Error reading favourites", event.getThrowable());
        } else {


        }
    }

    public void onEventMainThread(SyncEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.loginError(event.getThrowable().getMessage());
            }
            Log.e("Networking", "Error reading favourites", event.getThrowable());
        } else {
            screen.syncReady();
        }
    }
}
