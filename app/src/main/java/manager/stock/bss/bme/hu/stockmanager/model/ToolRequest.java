package manager.stock.bss.bme.hu.stockmanager.model;

import com.google.gson.annotations.SerializedName;


public class ToolRequest   {
  
  @SerializedName("name")
  private String name = null;
  
  @SerializedName("detail")
  private String detail = null;
  
  @SerializedName("barcodeSch")
  private String barcodeSch = null;
  
  @SerializedName("barcodeKi")
  private String barcodeKi = null;
  
  @SerializedName("barcode")
  private String barcode = null;
  
  @SerializedName("place")
  private String place = null;
  

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public String getDetail() {
    return detail;
  }
  public void setDetail(String detail) {
    this.detail = detail;
  }

  public String getBarcodeSch() {
    return barcodeSch;
  }
  public void setBarcodeSch(String barcodeSch) {
    this.barcodeSch = barcodeSch;
  }

  public String getBarcodeKi() {
    return barcodeKi;
  }
  public void setBarcodeKi(String barcodeKi) {
    this.barcodeKi = barcodeKi;
  }

  public String getBarcode() {
    return barcode;
  }
  public void setBarcode(String barcode) {
    this.barcode = barcode;
  }

  public String getPlace() {
    return place;
  }
  public void setPlace(String place) {
    this.place = place;
  }
}
