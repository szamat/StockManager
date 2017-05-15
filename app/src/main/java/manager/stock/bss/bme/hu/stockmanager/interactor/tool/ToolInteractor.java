package manager.stock.bss.bme.hu.stockmanager.interactor.tool;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import manager.stock.bss.bme.hu.stockmanager.StockApplication;
import manager.stock.bss.bme.hu.stockmanager.domain.Tool;
import manager.stock.bss.bme.hu.stockmanager.interactor.tool.event.GetToolEvent;
import manager.stock.bss.bme.hu.stockmanager.interactor.tool.event.GetToolsEvent;
import manager.stock.bss.bme.hu.stockmanager.interactor.tool.event.SyncEvent;
import manager.stock.bss.bme.hu.stockmanager.interactor.tool.event.RemoveToolEvent;
import manager.stock.bss.bme.hu.stockmanager.interactor.tool.event.SaveToolEvent;
import manager.stock.bss.bme.hu.stockmanager.model.LoginRequest;
import manager.stock.bss.bme.hu.stockmanager.model.LoginSuccessResponse;
import manager.stock.bss.bme.hu.stockmanager.model.ToolListRequest;
import manager.stock.bss.bme.hu.stockmanager.model.ToolRequest;
import manager.stock.bss.bme.hu.stockmanager.model.exception.LoginException;
import manager.stock.bss.bme.hu.stockmanager.network.stock.StockApi;
import manager.stock.bss.bme.hu.stockmanager.repository.ToolRepository;
import retrofit2.Response;

public class ToolInteractor {

    @Inject
    ToolRepository repository;

    @Inject
    EventBus bus;

    @Inject
    StockApi stockApi;

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

    public void removeToolById(Long id){
        RemoveToolEvent event = new RemoveToolEvent();
        try{
            Tool tool = repository.getToolById(id);
            repository.removeTool(tool);
            event.setTool(tool);
            bus.post(event);
        } catch (Exception ex){
            event.setThrowable(ex);
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

    public void doSync(String username, String password){
        SyncEvent event = new SyncEvent();
        try{
            LoginRequest loginR = new LoginRequest();
            loginR.setPassword(password);
            loginR.setUsername(username);

            Response<LoginSuccessResponse> loginSuccessResponse =
                    stockApi.loginPost(loginR).execute();

            if(loginSuccessResponse.code() == 200){
                List<Tool> tools = repository.getTools();
                ToolListRequest toolListRequest = getToolListRequest(tools);
                stockApi.toolsPut(toolListRequest);
                bus.post(event);
            } else if(loginSuccessResponse.code() == 401) {
                throw new LoginException("Invalid username or password!");
            } else {
                throw new LoginException("Something went wrong!");
            }

            bus.post(event);
        } catch(Exception e){
            event.setThrowable(e);
            bus.post(event);
        }

    }

    private ToolListRequest getToolListRequest(List<Tool> tools) {
        List<ToolRequest> toolRequests = new ArrayList<>();

        for(Tool t : tools){
            ToolRequest toolRequest = new ToolRequest();
            toolRequest.setBarcodeSch(t.getBarcodeSch());
            toolRequest.setBarcode(t.getBarcode());
            toolRequest.setBarcodeKi(t.getBarcodeKi());
            toolRequest.setDetail(t.getDetails());
            toolRequest.setName(t.getName());
            toolRequest.setPlace(t.getPlace());

            toolRequests.add(toolRequest);
        }

        ToolListRequest toolListRequest = new ToolListRequest();
        toolListRequest.setTools(toolRequests);
        return toolListRequest;
    }
}
