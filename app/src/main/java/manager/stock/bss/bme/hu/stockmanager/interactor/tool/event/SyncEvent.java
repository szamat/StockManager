package manager.stock.bss.bme.hu.stockmanager.interactor.tool.event;

import java.util.List;

import manager.stock.bss.bme.hu.stockmanager.domain.Tool;

public class SyncEvent {
    private int code;
    private String loginResult;
    private Throwable throwable;

    //<editor-fold desc="Constructors|Getters|Setters">

    public SyncEvent() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public String getLoginResult() {
        return loginResult;
    }

    public void setLoginResult(String loginResult) {
        this.loginResult = loginResult;
    }
}
