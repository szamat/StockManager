package manager.stock.bss.bme.hu.stockmanager;

import android.content.Context;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;
import manager.stock.bss.bme.hu.stockmanager.ui.Sync.SyncPresenter;
import manager.stock.bss.bme.hu.stockmanager.ui.main.MainPresenter;
import manager.stock.bss.bme.hu.stockmanager.ui.newTool.NewToolPresenter;
import manager.stock.bss.bme.hu.stockmanager.ui.tootDetail.ToolDetailPresenter;
import manager.stock.bss.bme.hu.stockmanager.utils.UiExecutor;
import manager.stock.bss.bme.hu.stockmanager.ui.UIModule;


@Module
public class TestModule {

	private final UIModule UIModule;

	public TestModule(Context context) {
		this.UIModule = new UIModule(context);
	}

	@Provides
	public Context provideContext() {
		return UIModule.provideContext();
	}


	@Provides
	public MainPresenter provideMainPresenter() {
		return UIModule.provideMainPresenter();
	}


	@Provides
	public NewToolPresenter provideNewToolPresenter() {
		return UIModule.provideNewToolPresenter();
	}


	@Provides
	public ToolDetailPresenter provideToolDetailPresenter() {
		return UIModule.provideToolDetailPresenter();
	}

	@Provides
	public SyncPresenter provideSyncPresenter() {
		return UIModule.provideSyncPresenter();
	}

	@Provides
	public EventBus provideEventBus() {
		return EventBus.getDefault();
	}

	@Provides
	@Singleton
	public Executor provideNetworkExecutor() {
		return new UiExecutor();
	}


}
