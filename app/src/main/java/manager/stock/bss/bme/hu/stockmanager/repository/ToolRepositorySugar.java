package manager.stock.bss.bme.hu.stockmanager.repository;

import android.content.Context;

import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.List;

import manager.stock.bss.bme.hu.stockmanager.domain.Tool;

public class ToolRepositorySugar implements ToolRepository {
    @Override
    public void open(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void close() {
        SugarContext.terminate();
    }

    @Override
    public List<Tool> getTools() {
        return SugarRecord.listAll(Tool.class);
    }

    @Override
    public Tool getToolById(Long id) {
        return SugarRecord.findById(Tool.class,id);
    }

    @Override
    public void saveTool(Tool tool) {
        SugarRecord.saveInTx(tool);
    }

    @Override
    public void removeTool(Tool tool) {
        SugarRecord.deleteInTx(tool);
    }

    @Override
    public boolean isInDB(Tool tool) {
        return  SugarRecord.findById(Tool.class, tool.getId()) != null;
    }
}
