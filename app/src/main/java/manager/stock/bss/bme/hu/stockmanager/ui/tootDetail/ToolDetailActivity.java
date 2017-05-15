package manager.stock.bss.bme.hu.stockmanager.ui.tootDetail;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import manager.stock.bss.bme.hu.stockmanager.R;
import manager.stock.bss.bme.hu.stockmanager.StockApplication;
import manager.stock.bss.bme.hu.stockmanager.domain.Tool;
import manager.stock.bss.bme.hu.stockmanager.ui.Sync.SyncActivity;
import manager.stock.bss.bme.hu.stockmanager.ui.main.MainActivity;
import manager.stock.bss.bme.hu.stockmanager.ui.newTool.NewToolActivity;

import static android.R.attr.value;

public class ToolDetailActivity extends AppCompatActivity implements ToolDetailScreen {

    @Inject
    ToolDetailPresenter toolDetailPresenter;

    Long toolId;

    private NavigationView navigationView;

    private TextView toolName;
    private TextView toolDetail;
    private TextView toolInvSch;
    private TextView toolInvKi;
    private TextView toolPlace;
    private TextView toolBarcode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_detail);

        setTitle("Stock Manager - Tool Details");

        StockApplication.injector.inject(this);

        navigationView = (NavigationView) findViewById(R.id.navigation);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_new_tool:
                        Intent myIntent = new Intent(ToolDetailActivity.this, NewToolActivity.class);
                        myIntent.putExtra("key", value); //Optional parameters
                        ToolDetailActivity.this.startActivity(myIntent);
                        break;
                    case R.id.nav_sync:
                        myIntent = new Intent(ToolDetailActivity.this, SyncActivity.class);
                        ToolDetailActivity.this.startActivity(myIntent);
                        break;
                    case R.id.nav_main:
                        myIntent = new Intent(ToolDetailActivity.this, MainActivity.class);
                        ToolDetailActivity.this.startActivity(myIntent);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        toolId = getIntent().getLongExtra("id",-1);

        toolName = (TextView) findViewById(R.id.tool_name);
        toolDetail = (TextView) findViewById(R.id.tool_detail);
        toolInvSch = (TextView) findViewById(R.id.tool_inv_sch);
        toolInvKi = (TextView) findViewById(R.id.tool_inv_ki);
        toolPlace = (TextView) findViewById(R.id.tool_place);
        toolBarcode = (TextView) findViewById(R.id.tool_barcode);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_delete) {
            toolDetailPresenter.deleteTool(toolId);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        toolDetailPresenter.attachScreen(this);
        toolDetailPresenter.getTool(toolId);
    }

    @Override
    protected void onStop() {
        super.onStop();
        toolDetailPresenter.detachScreen();
    }

    @Override
    public void showToolDetails(Tool toolDetails) {
        toolName.setText(toolDetails.getName());
        toolDetail.setText(toolDetails.getDetails());
        toolInvSch.setText(toolDetails.getBarcodeSch());
        toolInvKi.setText(toolDetails.getBarcodeKi());
        toolPlace.setText(toolDetails.getPlace());
        toolBarcode.setText(toolDetails.getBarcode());
    }

    @Override
    public void deleteSuccess() {
        Toast.makeText(this,"Successfully deleted",Toast.LENGTH_LONG).show();
        Intent i = new Intent(ToolDetailActivity.this,MainActivity.class);
        ToolDetailActivity.this.startActivity(i);

    }
}
