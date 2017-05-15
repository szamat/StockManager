package manager.stock.bss.bme.hu.stockmanager.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.annotation.Config;

import java.util.List;

import manager.stock.bss.bme.hu.stockmanager.BuildConfig;
import manager.stock.bss.bme.hu.stockmanager.ui.Sync.SyncPresenter;
import manager.stock.bss.bme.hu.stockmanager.ui.Sync.SyncScreen;
import manager.stock.bss.bme.hu.stockmanager.ui.newTool.NewToolPresenter;
import manager.stock.bss.bme.hu.stockmanager.ui.newTool.NewToolScreen;
import manager.stock.bss.bme.hu.stockmanager.utils.RobolectricDaggerTestRunner;

import static manager.stock.bss.bme.hu.stockmanager.TestHelper.setTestInjector;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class SyncPresenterTest {

    private SyncPresenter syncPresenter;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        syncPresenter = new SyncPresenter();
    }

    @Test
    public void testSync() {
        SyncScreen syncScreen = mock(SyncScreen.class);
        syncPresenter.attachScreen(syncScreen);

        syncPresenter.doSync(any(String.class),any(String.class));

        verify(syncScreen).syncReady();
    }



    @After
    public void tearDown() {
        syncPresenter.detachScreen();
    }
}