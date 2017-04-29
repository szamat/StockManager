package manager.stock.bss.bme.hu.stockmanager.repository;

import android.content.Context;

import java.util.List;

import manager.stock.bss.bme.hu.stockmanager.domain.Tool;

public interface ToolRepository {
    void open(Context context);

    void close();

    List<Tool> getTools();

    Tool getToolById(Long id);

    void saveTool(Tool tool);

    void removeTool(Tool tool);

    boolean isInDB(Tool tool);
}
