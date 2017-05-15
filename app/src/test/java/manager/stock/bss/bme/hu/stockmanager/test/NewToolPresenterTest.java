package manager.stock.bss.bme.hu.stockmanager.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.annotation.Config;

import java.util.List;

import javax.inject.Inject;

import manager.stock.bss.bme.hu.stockmanager.BuildConfig;
import manager.stock.bss.bme.hu.stockmanager.domain.Tool;
import manager.stock.bss.bme.hu.stockmanager.repository.ToolRepository;
import manager.stock.bss.bme.hu.stockmanager.ui.main.MainPresenter;
import manager.stock.bss.bme.hu.stockmanager.ui.main.MainScreen;
import manager.stock.bss.bme.hu.stockmanager.ui.newTool.NewToolPresenter;
import manager.stock.bss.bme.hu.stockmanager.ui.newTool.NewToolScreen;
import manager.stock.bss.bme.hu.stockmanager.utils.RobolectricDaggerTestRunner;

import static manager.stock.bss.bme.hu.stockmanager.TestHelper.setTestInjector;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class NewToolPresenterTest {

   private NewToolPresenter newToolPresenter;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        newToolPresenter = new NewToolPresenter();
    }

    @Test
    public void testSaveNewTool() {
        NewToolScreen newToolScreen = mock(NewToolScreen.class);
        newToolPresenter.attachScreen(newToolScreen);

        Tool t = mock(Tool.class);

        newToolPresenter.saveTools(t);
        verify(newToolScreen).savedSuccessfull();
    }



    @After
    public void tearDown() {
        newToolPresenter.detachScreen();
    }
}