package manager.stock.bss.bme.hu.stockmanager;

import javax.inject.Singleton;

import dagger.Component;
import manager.stock.bss.bme.hu.stockmanager.ui.Sync.SyncActivity;
import manager.stock.bss.bme.hu.stockmanager.ui.UIModule;
import manager.stock.bss.bme.hu.stockmanager.ui.main.MainActivity;
import manager.stock.bss.bme.hu.stockmanager.ui.newTool.NewToolActivity;
import manager.stock.bss.bme.hu.stockmanager.ui.tootDetail.ToolDetailActivity;
import manager.stock.bss.bme.hu.stockmanager.ui.tootDetail.ToolDetailPresenter;

@Singleton
@Component(modules = {UIModule.class})
public interface StockApplicationComponent {
    void inject(MainActivity mainActivity);
    void inject(NewToolActivity newToolActivity);
    void inject(ToolDetailActivity toolDetailActivity);
    void inject(SyncActivity syncActivity);

}
