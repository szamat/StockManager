package manager.stock.bss.bme.hu.stockmanager.ui.newTool;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import manager.stock.bss.bme.hu.stockmanager.interactor.tool.ToolInteractor;
import manager.stock.bss.bme.hu.stockmanager.ui.Presenter;
import manager.stock.bss.bme.hu.stockmanager.domain.Tool;

import static manager.stock.bss.bme.hu.stockmanager.StockApplication.injector;

public class NewToolPresenter extends Presenter<NewToolScreen>{

    @Inject
    ToolInteractor toolInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;


    public NewToolPresenter() {
    }

    @Override
    public void attachScreen(NewToolScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

     public void saveTools(final Tool tool) {
         executor.execute(new Runnable() {
             @Override
             public void run() {
                 toolInteractor.saveTool(tool);
             }
         });
     }
}

