package manager.stock.bss.bme.hu.stockmanager.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.annotation.Config;

import java.util.List;


import manager.stock.bss.bme.hu.stockmanager.BuildConfig;
import manager.stock.bss.bme.hu.stockmanager.domain.Tool;
import manager.stock.bss.bme.hu.stockmanager.ui.main.MainPresenter;
import manager.stock.bss.bme.hu.stockmanager.ui.main.MainScreen;
import manager.stock.bss.bme.hu.stockmanager.utils.RobolectricDaggerTestRunner;

import static manager.stock.bss.bme.hu.stockmanager.TestHelper.setTestInjector;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MainPresenterTest {

    private MainPresenter mainPresenter;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        mainPresenter = new MainPresenter();
    }

    @Test
    public void testStock() {
        MainScreen mainScreen = mock(MainScreen.class);
        mainPresenter.attachScreen(mainScreen);

        ArgumentCaptor<List> argument = ArgumentCaptor.forClass(List.class);
        mainPresenter.getTools();
        verify(mainScreen, times(1)).loadToolList(argument.capture());

        List<Tool> list = argument.getValue(); // first captured List, etc.

        assertEquals("Sony EX3 camera", list.get(0).getName());
        assertEquals("Sony 320 camera", list.get(1).getName());
    }



    @After
    public void tearDown() {
        mainPresenter.detachScreen();
    }
}