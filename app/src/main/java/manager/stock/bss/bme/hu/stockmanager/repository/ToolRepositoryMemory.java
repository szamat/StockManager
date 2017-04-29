package manager.stock.bss.bme.hu.stockmanager.repository;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import manager.stock.bss.bme.hu.stockmanager.domain.Tool;

public class ToolRepositoryMemory implements ToolRepository {

    public static List<Tool> tools;

    @Override
    public void open(Context context) {
        Tool tool1 = new Tool(1l,"Sony EX3 camera","-","SCH1","KI1","1","Vault");
        Tool tool2 = new Tool(2l,"Sony 320 camera","-","SCH2","KI2","2","Vault");

        tools = new ArrayList<>();
        tools.add(tool1);
        tools.add(tool2);
    }

    @Override
    public void close() {

    }

    @Override
    public List<Tool> getTools() {
        return tools;
    }

    @Override
    public Tool getToolById(Long id) {
        Tool tool = null;
        for(Tool t : tools){
            if(t.getId() == id){
                tool = t;
            }
        }
        return tool;
    }

    @Override
    public void saveTool(Tool saveTool) {
        Tool tool = null;
        for(Tool t : tools){
            if(t.getId() == saveTool.getId()){
                tool = t;
            }
        }
        if(tool != null)
            tool = saveTool;
        else
            tools.add(saveTool);
    }

    @Override
    public void removeTool(Tool tool) {
        for(Tool t : tools){
            if(t.getId() == tool.getId()){
                tools.remove(t);
            }
        }

    }

    @Override
    public boolean isInDB(Tool tool) {
        for(Tool t : tools){
            if(t.getId() == tool.getId()){
                return true;
            }
        }
        return false;
    }
}
