package manager.stock.bss.bme.hu.stockmanager.ui.Sync;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import manager.stock.bss.bme.hu.stockmanager.R;
import manager.stock.bss.bme.hu.stockmanager.StockApplication;
import manager.stock.bss.bme.hu.stockmanager.ui.main.MainActivity;
import manager.stock.bss.bme.hu.stockmanager.ui.newTool.NewToolActivity;

import static android.R.attr.value;

public class SyncActivity extends AppCompatActivity implements SyncScreen{

    private NavigationView navigationView;

    @Inject
    SyncPresenter syncPresenter;

    private EditText username;

    private EditText password;

    private Button syncButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StockApplication.injector.inject(this);

        setContentView(R.layout.activity_sync);

        setTitle("Stock Manager - Synchronization");

        navigationView = (NavigationView) findViewById(R.id.navigation);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_main:
                        Intent myIntent = new Intent(SyncActivity.this, MainActivity.class);
                        myIntent.putExtra("key", value); //Optional parameters
                        SyncActivity.this.startActivity(myIntent);
                        break;
                    case R.id.nav_new_tool:
                        myIntent = new Intent(SyncActivity.this, NewToolActivity.class);
                        myIntent.putExtra("key", value); //Optional parameters
                        SyncActivity.this.startActivity(myIntent);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        username = (EditText) findViewById(R.id.sync_username);
        password = (EditText) findViewById(R.id.sync_password);

        syncButton = (Button) findViewById(R.id.sync_button);

        syncButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!"".equals(username.getText().toString()) &&
                        !"".equals(password.getText().toString())) {
                    syncPresenter.doSync(username.getText().toString(),
                            password.getText().toString());
                } else {
                    Toast.makeText(SyncActivity.this,"Please give both username and password",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

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
        Toast.makeText(this,errorMessage,Toast.LENGTH_LONG).show();
    }

    @Override
    public void syncReady() {
        Toast.makeText(this,"Synchronization ready",Toast.LENGTH_LONG).show();
    }

    @Override
    public void syncError() {

    }
}
