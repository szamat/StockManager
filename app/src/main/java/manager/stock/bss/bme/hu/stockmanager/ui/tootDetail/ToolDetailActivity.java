package manager.stock.bss.bme.hu.stockmanager.ui.tootDetail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import manager.stock.bss.bme.hu.stockmanager.R;
import manager.stock.bss.bme.hu.stockmanager.StockApplication;
import manager.stock.bss.bme.hu.stockmanager.dto.ToolDetails;

public class ToolDetailActivity extends AppCompatActivity implements ToolDetailScreen {

    @Inject
    ToolDetailPresenter toolDetailPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_detail);

        StockApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        toolDetailPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        toolDetailPresenter.detachScreen();
    }

    @Override
    public void showToolDetails(ToolDetails toolDetails) {
        //TODO show the details of the tool
    }
}
