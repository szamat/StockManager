package manager.stock.bss.bme.hu.stockmanager.ui.main;

import java.util.ArrayList;
import java.util.List;

import manager.stock.bss.bme.hu.stockmanager.dto.ToolListElement;
import manager.stock.bss.bme.hu.stockmanager.ui.Presenter;

public class MainPresenter extends Presenter<MainScreen>{

    public MainPresenter() {
    }

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
        List<ToolListElement> toolListElements = new ArrayList<>();
        //TODO load the tools to the list
        screen.loadToolList(toolListElements);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }


}
