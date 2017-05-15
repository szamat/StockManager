package manager.stock.bss.bme.hu.stockmanager.ui.tootDetail;

import manager.stock.bss.bme.hu.stockmanager.domain.Tool;

public interface ToolDetailScreen {
    void showToolDetails(Tool toolDetails);
    void deleteSuccess();
}
