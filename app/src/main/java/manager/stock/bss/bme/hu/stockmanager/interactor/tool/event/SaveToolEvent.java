package manager.stock.bss.bme.hu.stockmanager.interactor.tool.event;

import manager.stock.bss.bme.hu.stockmanager.domain.Tool;

public class SaveToolEvent {
    private int code;
    private Tool tool;
    private Throwable throwable;

    //<editor-fold desc="Constructors|Getters|Setters">

    public SaveToolEvent() {
    }

    public SaveToolEvent(int code, Tool tool, Throwable throwable) {
        this.code = code;
        this.tool = tool;
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    //</editor-fold>
}
