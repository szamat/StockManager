package manager.stock.bss.bme.hu.stockmanager.ui.newTool;

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
import manager.stock.bss.bme.hu.stockmanager.domain.Tool;
import manager.stock.bss.bme.hu.stockmanager.ui.Sync.SyncActivity;
import manager.stock.bss.bme.hu.stockmanager.ui.main.MainActivity;

import static android.R.attr.value;

public class NewToolActivity extends AppCompatActivity implements NewToolScreen{

    private NavigationView navigationView;

    @Inject
    NewToolPresenter newToolPresenter;

    private EditText newToolName;
    private EditText newToolDetail;
    private EditText newToolInvSch;
    private EditText newToolInvKi;
    private EditText newToolPlace;
    private EditText newToolBarcode;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_tool);

        setTitle("Stock Manager - Add New Tool");

        StockApplication.injector.inject(this);

        navigationView = (NavigationView) findViewById(R.id.navigation);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_main:
                        Intent myIntent = new Intent(NewToolActivity.this, MainActivity.class);
                        myIntent.putExtra("key", value); //Optional parameters
                        NewToolActivity.this.startActivity(myIntent);
                        break;
                    case R.id.nav_sync:
                        myIntent = new Intent(NewToolActivity.this, SyncActivity.class);
                        myIntent.putExtra("key", value); //Optional parameters
                        NewToolActivity.this.startActivity(myIntent);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        newToolName = (EditText) findViewById(R.id.new_tool_name);
        newToolDetail = (EditText) findViewById(R.id.new_tool_detail);
        newToolInvSch = (EditText) findViewById(R.id.new_tool_inv_sch);
        newToolInvKi = (EditText) findViewById(R.id.new_tool_inv_ki);
        newToolPlace = (EditText) findViewById(R.id.new_tool_place);
        newToolBarcode = (EditText) findViewById(R.id.new_tool_barcode);

        button = (Button) findViewById(R.id.new_tool_save);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkInputs()){
                    newToolPresenter.saveTools(getTool());
                } else {
                    Toast.makeText(NewToolActivity.this, "All field is required!",Toast.LENGTH_LONG)
                            .show();
                }
            }
        });
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

    @Override
    public void savedSuccessfull() {
        Toast.makeText(this,"Added a new tool.",Toast.LENGTH_SHORT).show();
        newToolName.setText("");
        newToolDetail.setText("");
        newToolInvSch.setText("");
        newToolInvKi.setText("");
        newToolPlace.setText("");
        newToolBarcode.setText("");
    }

    private boolean checkInputs(){
        boolean ok = true;
        if("".equals(newToolName.getText().toString())){
            ok = false;
        }
        if("".equals(newToolDetail.getText().toString())){
            ok = false;
        }
        if("".equals(newToolInvSch.getText().toString())){
            ok = false;
        }
        if("".equals(newToolInvKi.getText().toString())){
            ok = false;
        }
        if("".equals(newToolPlace.getText().toString())){
            ok = false;
        }
        if("".equals(newToolBarcode.getText().toString())){
            ok = false;
        }

        return ok;
    }

    private Tool getTool(){
        Tool t = new Tool();
        t.setBarcode(newToolBarcode.getText().toString());
        t.setBarcodeKi(newToolInvKi.getText().toString());
        t.setBarcodeSch(newToolInvSch.getText().toString());
        t.setDetails(newToolDetail.getText().toString());
        t.setPlace(newToolPlace.getText().toString());
        t.setName(newToolName.getText().toString());

        return t;
    }

}
