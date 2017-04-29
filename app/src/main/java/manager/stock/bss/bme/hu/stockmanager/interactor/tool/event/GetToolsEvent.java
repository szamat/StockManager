package manager.stock.bss.bme.hu.stockmanager.interactor.tool.event;

import java.util.List;

import manager.stock.bss.bme.hu.stockmanager.domain.Tool;

public class GetToolsEvent {
    private int code;
    private List<Tool> tools;
    private Throwable throwable;

    //<editor-fold desc="Constructors|Getters|Setters">

    public GetToolsEvent() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Tool> getTools() {
        return tools;
    }

    public void setTools(List<Tool> tools) {
        this.tools = tools;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
