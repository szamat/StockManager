package manager.stock.bss.bme.hu.stockmanager.ui.Sync;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import manager.stock.bss.bme.hu.stockmanager.interactor.tool.ToolInteractor;
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

    @Override
    public void attachScreen(SyncScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }
}
