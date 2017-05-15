package manager.stock.bss.bme.hu.stockmanager.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;


public class ToolListResponse   {
  
  @SerializedName("tools")
  private List<ToolResponse> tools = new ArrayList<ToolResponse>();
  
  @SerializedName("addNewToolUri")
  private String addNewToolUri = null;

  public List<ToolResponse> getTools() {
    return tools;
  }
  public void setTools(List<ToolResponse> tools) {
    this.tools = tools;
  }

  public String getAddNewToolUri() {
    return addNewToolUri;
  }
  public void setAddNewToolUri(String addNewToolUri) {
    this.addNewToolUri = addNewToolUri;
  }
}
