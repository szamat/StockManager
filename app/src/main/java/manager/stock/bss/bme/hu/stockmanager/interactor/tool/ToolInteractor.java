package manager.stock.bss.bme.hu.stockmanager.interactor.tool;

import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import manager.stock.bss.bme.hu.stockmanager.StockApplication;
import manager.stock.bss.bme.hu.stockmanager.domain.Tool;
import manager.stock.bss.bme.hu.stockmanager.interactor.tool.event.GetToolEvent;
import manager.stock.bss.bme.hu.stockmanager.interactor.tool.event.GetToolsEvent;
import manager.stock.bss.bme.hu.stockmanager.interactor.tool.event.RemoveToolEvent;
import manager.stock.bss.bme.hu.stockmanager.interactor.tool.event.SaveToolEvent;
import manager.stock.bss.bme.hu.stockmanager.repository.ToolRepository;

public class ToolInteractor {
    @Inject
    ToolRepository repository;

    @Inject
    EventBus bus;

    public ToolInteractor() {
        StockApplication.injector.inject(this);
    }

    public void getTools() {
        GetToolsEvent event = new GetToolsEvent();
        try {
            List<Tool> tools = repository.getTools();
            event.setTools(tools);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void getTool(Long id) {
        GetToolEvent event = new GetToolEvent();
        try {
            Tool tool = repository.getToolById(id);
            event.setTool(tool);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void saveTool(Tool tool) {

        SaveToolEvent event = new SaveToolEvent();
        event.setTool(tool);
        try {
            repository.saveTool(tool);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }


    public void removeTool(Tool tool) {
        RemoveToolEvent event = new RemoveToolEvent();
        event.setTool(tool);
        try {
            repository.removeTool(tool);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

}
