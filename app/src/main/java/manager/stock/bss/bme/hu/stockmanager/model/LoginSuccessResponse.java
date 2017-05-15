package manager.stock.bss.bme.hu.stockmanager.model;

import com.google.gson.annotations.SerializedName;

public class LoginSuccessResponse   {
  
  @SerializedName("username")
  private String username = null;
  
  @SerializedName("getToolsUri")
  private String getToolsUri = null;

  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }

  public String getGetToolsUri() {
    return getToolsUri;
  }
  public void setGetToolsUri(String getToolsUri) {
    this.getToolsUri = getToolsUri;
  }
}
