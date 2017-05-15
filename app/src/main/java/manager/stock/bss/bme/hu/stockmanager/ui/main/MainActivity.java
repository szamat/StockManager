package manager.stock.bss.bme.hu.stockmanager.ui.main;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.RecyclerView;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import manager.stock.bss.bme.hu.stockmanager.R;
import manager.stock.bss.bme.hu.stockmanager.StockApplication;
import manager.stock.bss.bme.hu.stockmanager.domain.Tool;
import manager.stock.bss.bme.hu.stockmanager.ui.Sync.SyncActivity;
import manager.stock.bss.bme.hu.stockmanager.ui.newTool.NewToolActivity;
import manager.stock.bss.bme.hu.stockmanager.ui.tootDetail.ToolDetailActivity;

import static android.R.attr.defaultHeight;
import static android.R.attr.value;

public class MainActivity extends AppCompatActivity implements MainScreen, ToolAdapter.ClickListener{

    private RecyclerView toolRecyclerView;
    private ToolAdapter toolAdapter;

    private NavigationView navigationView;

    private List<Tool> tools;

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Stock Manager - Tools");

        StockApplication.injector.inject(this);

        navigationView = (NavigationView) findViewById(R.id.navigation);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_new_tool:
                        Intent myIntent = new Intent(MainActivity.this, NewToolActivity.class);
                        myIntent.putExtra("key", value); //Optional parameters
                        MainActivity.this.startActivity(myIntent);
                        break;
                    case R.id.nav_sync:
                        myIntent = new Intent(MainActivity.this, SyncActivity.class);
                        myIntent.putExtra("key", value); //Optional parameters
                        MainActivity.this.startActivity(myIntent);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        toolRecyclerView = (RecyclerView) findViewById(R.id.toolList);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        toolRecyclerView.setLayoutManager(llm);

        tools = new ArrayList<>();
        toolAdapter = new ToolAdapter(this,tools);
        toolAdapter.setClickListener(this);
        toolRecyclerView.setAdapter(toolAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);

        mainPresenter.getTools();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detachScreen();
    }

    @Override
    public void loadToolList(List<Tool> tools) {
       this.tools.clear();
        this.tools.addAll(tools);
        toolAdapter.notifyDataSetChanged();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void onToolClickCalled(String anyValue) {
        // Call another acitivty here and pass some arguments to it.
    }

    @Override
    public void itemClicked(View view, int position) {
        Tool t = tools.get(position);
        Intent i = new Intent(MainActivity.this,ToolDetailActivity.class);
        i.putExtra("id", t.getId());
        MainActivity.this.startActivity(i);
    }
}
