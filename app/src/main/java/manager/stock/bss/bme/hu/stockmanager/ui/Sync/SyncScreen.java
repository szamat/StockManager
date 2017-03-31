package manager.stock.bss.bme.hu.stockmanager.ui.Sync;

public interface SyncScreen {
    void loginError(String errorMessage);
    void syncReady();
    void syncError();
}
