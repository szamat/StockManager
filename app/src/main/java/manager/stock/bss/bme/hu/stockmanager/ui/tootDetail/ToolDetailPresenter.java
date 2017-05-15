package manager.stock.bss.bme.hu.stockmanager.ui.tootDetail;

import android.util.Log;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import manager.stock.bss.bme.hu.stockmanager.interactor.tool.ToolInteractor;
import manager.stock.bss.bme.hu.stockmanager.interactor.tool.event.GetToolEvent;
import manager.stock.bss.bme.hu.stockmanager.interactor.tool.event.RemoveToolEvent;
import manager.stock.bss.bme.hu.stockmanager.interactor.tool.event.SaveToolEvent;
import manager.stock.bss.bme.hu.stockmanager.ui.Presenter;
import manager.stock.bss.bme.hu.stockmanager.domain.Tool;

import static manager.stock.bss.bme.hu.stockmanager.StockApplication.injector;

public class ToolDetailPresenter extends Presenter<ToolDetailScreen> {

    @Inject
    ToolInteractor toolInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public ToolDetailPresenter() {
    }

    @Override
    public void attachScreen(ToolDetailScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        bus.unregister(this);
    }

    public void deleteTool(final Long id){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                toolInteractor.removeToolById(id);
            }
        });
    }

    public void getTool(final Long id) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                toolInteractor.getTool(id);
            }
        });
    }

    public void onEventMainThread(GetToolEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {

            }
            Log.e("Networking", "Error reading favourites", event.getThrowable());
        } else {
            screen.showToolDetails(event.getTool());
        }
    }

    public void onEventMainThread(RemoveToolEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {

            }
            Log.e("Networking", "Error reading favourites", event.getThrowable());
        } else {
            screen.deleteSuccess();
        }
    }

}
