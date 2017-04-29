package manager.stock.bss.bme.hu.stockmanager.ui.tootDetail;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import manager.stock.bss.bme.hu.stockmanager.interactor.tool.ToolInteractor;
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
    }

    public void deleteTool(Long id){
        //TODO implement
    }

    public void getTool(final Long id) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                toolInteractor.getTool(id);
            }
        });
    }

    public void deleteTool(final Tool tool) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                toolInteractor.removeTool(tool);
            }
        });
    }

}
