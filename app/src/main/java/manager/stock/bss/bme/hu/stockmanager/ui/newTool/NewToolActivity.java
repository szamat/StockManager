package manager.stock.bss.bme.hu.stockmanager.ui.newTool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import javax.inject.Inject;

import manager.stock.bss.bme.hu.stockmanager.R;
import manager.stock.bss.bme.hu.stockmanager.StockApplication;

public class NewToolActivity extends AppCompatActivity implements NewToolScreen{

    @Inject
    NewToolPresenter newToolPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_tool);

        StockApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        newToolPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        newToolPresenter.detachScreen();
    }

    @Override
    public void barcodeAlreadyInUse() {
        Toast.makeText(this, "This barcode is already in use, choose an other one!", Toast.LENGTH_SHORT).show();
    }
}
