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
import manager.stock.bss.bme.hu.stockmanager.ui.Sync.SyncPresenter;
import manager.stock.bss.bme.hu.stockmanager.ui.Sync.SyncScreen;
import manager.stock.bss.bme.hu.stockmanager.ui.tootDetail.ToolDetailPresenter;
import manager.stock.bss.bme.hu.stockmanager.ui.tootDetail.ToolDetailScreen;
import manager.stock.bss.bme.hu.stockmanager.utils.RobolectricDaggerTestRunner;

import static manager.stock.bss.bme.hu.stockmanager.TestHelper.setTestInjector;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class ToolDetailPresenterTest {

    private ToolDetailPresenter toolDetailPresenter;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        toolDetailPresenter = new ToolDetailPresenter();
    }

    @Test
    public void testGetToolDetail() {
        ToolDetailScreen toolDetailScreen = mock(ToolDetailScreen.class);
        toolDetailPresenter.attachScreen(toolDetailScreen);

        toolDetailPresenter.getTool(1l);
        ArgumentCaptor<Tool> toolCaptor = ArgumentCaptor.forClass(Tool.class);
        verify(toolDetailScreen).showToolDetails(toolCaptor.capture());

        Tool capturedTool = toolCaptor.getValue();
        assertEquals("Sony EX3 camera", capturedTool.getName());
    }

    @Test
    public void testDeleteTool() {
        ToolDetailScreen toolDetailScreen = mock(ToolDetailScreen.class);
        toolDetailPresenter.attachScreen(toolDetailScreen);

        toolDetailPresenter.deleteTool(1l);
        verify(toolDetailScreen).deleteSuccess();
    }



    @After
    public void tearDown() {
        toolDetailPresenter.detachScreen();
    }
}