package com.example.egaviria.defaultactivities.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.egaviria.defaultactivities.R;
import com.example.egaviria.defaultactivities.adapters.myCustomAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class GridViewActivity extends AppCompatActivity {

    private GridView myGridView;
    private String[] imPhoneTypes;
    private ArrayList<String> textString;
    private myCustomAdapter mCustomAdapter;
    private int counter = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        bindUI();
        adapterGridCustom();

        registerForContextMenu(myGridView);
    }


    private void adapterGridCustom() {
        textString = new ArrayList<>(Arrays.asList(imPhoneTypes));
        mCustomAdapter = new myCustomAdapter(this, textString, true);
        myGridView.setAdapter(mCustomAdapter);
    }

    private void bindUI() {
        imPhoneTypes = this.getResources().getStringArray(android.R.array.phoneTypes);
        myGridView = findViewById(R.id.myGridView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.custom_options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.add_item:
                this.textString.add("item " + (++counter));
                this.mCustomAdapter.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;

        menu.setHeaderTitle(this.textString.get(info.position));

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.custom_contex_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()){

            case R.id.delete_item:
                this.textString.remove(info.position);
                this.mCustomAdapter.notifyDataSetChanged();
                return true;

            case R.id.rename_item:
                this.textString.set(info.position, "R_" + this.textString.get(info.position));
                this.mCustomAdapter.notifyDataSetChanged();
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }
}
