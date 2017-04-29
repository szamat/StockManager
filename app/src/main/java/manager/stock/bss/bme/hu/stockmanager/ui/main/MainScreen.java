package manager.stock.bss.bme.hu.stockmanager.ui.main;

import java.util.List;

import manager.stock.bss.bme.hu.stockmanager.domain.Tool;
import manager.stock.bss.bme.hu.stockmanager.dto.ToolListElement;

public interface MainScreen {
    void loadToolList(List<Tool> tools);

    void showMessage(String message);
}
