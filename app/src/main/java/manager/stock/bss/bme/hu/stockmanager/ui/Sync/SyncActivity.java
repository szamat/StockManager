package manager.stock.bss.bme.hu.stockmanager.ui.Sync;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import manager.stock.bss.bme.hu.stockmanager.R;

public class SyncActivity extends AppCompatActivity implements SyncScreen{

    @Inject
    SyncPresenter syncPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sync);
    }

    @Override
    protected void onStart() {
        super.onStart();
        syncPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        syncPresenter.detachScreen();
    }

    @Override
    public void loginError(String errorMessage) {

    }

    @Override
    public void syncReady() {

    }

    @Override
    public void syncError() {

    }
}
