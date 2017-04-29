package manager.stock.bss.bme.hu.stockmanager.interactor;

import dagger.Module;
import dagger.Provides;
import manager.stock.bss.bme.hu.stockmanager.interactor.tool.ToolInteractor;

@Module
public class InteractorModule {

    @Provides
    public ToolInteractor provideTools() {
        return new ToolInteractor();
    }

}
