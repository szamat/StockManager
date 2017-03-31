package manager.stock.bss.bme.hu.stockmanager.ui;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import manager.stock.bss.bme.hu.stockmanager.ui.Sync.SyncPresenter;
import manager.stock.bss.bme.hu.stockmanager.ui.main.MainPresenter;
import manager.stock.bss.bme.hu.stockmanager.ui.newTool.NewToolPresenter;
import manager.stock.bss.bme.hu.stockmanager.ui.tootDetail.ToolDetailPresenter;

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    @Singleton
    public NewToolPresenter provideNewToolPresenter() {
        return new NewToolPresenter();
    }

    @Provides
    @Singleton
    public ToolDetailPresenter provideToolDetailPresenter() {
        return new ToolDetailPresenter();
    }

    @Provides
    @Singleton
    public SyncPresenter provideSyncPresenter() {
        return new SyncPresenter();
    }
}
