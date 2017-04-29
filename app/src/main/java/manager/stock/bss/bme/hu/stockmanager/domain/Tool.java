package manager.stock.bss.bme.hu.stockmanager.domain;

import com.orm.dsl.Table;

@Table
public class Tool {
    private Long id = null;
    private String name;
    private String details = null;
    private String barcodeSch = null;
    private String barcodeKi = null;
    private String barcode = null;
    private String place = null;

    public Tool() {
    }

    public Tool(Long id, String name, String details, String barcodeSch,
                String barcodeKi, String barcode, String place) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.barcode = barcode;
        this.barcodeKi = barcodeKi;
        this.barcodeSch = barcodeSch;
        this.place = place;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
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
