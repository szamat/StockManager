package manager.stock.bss.bme.hu.stockmanager;

import javax.inject.Singleton;

import dagger.Component;
import manager.stock.bss.bme.hu.stockmanager.interactor.InteractorModule;
import manager.stock.bss.bme.hu.stockmanager.interactor.tool.ToolInteractor;
import manager.stock.bss.bme.hu.stockmanager.mock.MockNetworkModule;
import manager.stock.bss.bme.hu.stockmanager.network.NetworkModule;
import manager.stock.bss.bme.hu.stockmanager.repository.RepositoryModule;
import manager.stock.bss.bme.hu.stockmanager.ui.Sync.SyncActivity;
import manager.stock.bss.bme.hu.stockmanager.ui.Sync.SyncPresenter;
import manager.stock.bss.bme.hu.stockmanager.ui.UIModule;
import manager.stock.bss.bme.hu.stockmanager.ui.main.MainActivity;
import manager.stock.bss.bme.hu.stockmanager.ui.main.MainPresenter;
import manager.stock.bss.bme.hu.stockmanager.ui.newTool.NewToolActivity;
import manager.stock.bss.bme.hu.stockmanager.ui.newTool.NewToolPresenter;
import manager.stock.bss.bme.hu.stockmanager.ui.tootDetail.ToolDetailActivity;
import manager.stock.bss.bme.hu.stockmanager.ui.tootDetail.ToolDetailPresenter;

@Singleton
@Component(modules = {UIModule.class, InteractorModule.class, RepositoryModule.class, MockNetworkModule.class})
public interface StockApplicationComponent {

    void inject(StockApplication stockApplication);

    void inject(MainActivity mainActivity);
    void inject(NewToolActivity newToolActivity);
    void inject(ToolDetailActivity toolDetailActivity);
    void inject(SyncActivity syncActivity);

    void inject(ToolInteractor toolInteractor);

    void inject(MainPresenter mainPresenter);
    void inject(NewToolPresenter newToolPresenter);
    void inject(SyncPresenter syncPresenter);
    void inject(ToolDetailPresenter toolDetailPresenter);
}
