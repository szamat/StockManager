package manager.stock.bss.bme.hu.stockmanager.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ToolListRequest{
    @SerializedName("tools")
    private List<ToolRequest> tools = new ArrayList<ToolRequest>();

    public List<ToolRequest> getTools() {
        return tools;
    }
    public void setTools(List<ToolRequest> tools) {
        this.tools = tools;
    }
}
