package com.example.egaviria.defaultactivities.recycler_view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.egaviria.defaultactivities.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<String> myDataset;

    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        bindUI();
    }

    private void bindUI() {
        myDataset = this.getAllNames();

        mRecyclerView = findViewById(R.id.myRecyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        //        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
//        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager = new GridLayoutManager(this, 2);
//        mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        // specify an adapter (see also next example)
        mAdapter = new MyRecyclerViewAdapter(myDataset, R.layout.recycler_view_layout, new MyRecyclerViewAdapter
                .OnItemClickListener() {
            @Override
            public void onItemClick(String name, int position) {

                removeRecyclerViewItem(position);
//                Toast.makeText(RecyclerViewActivity.this, "el nombre es: " + name + "la posicion es: " + position, Toast
//                        .LENGTH_SHORT).show();
            }
        });


        //        si estamos seguros que el tamaño de nuestro layout no va a cambiar. Mejora bastante el rendimiento
        mRecyclerView.setHasFixedSize(true);

        //        añade una anumacion por defecto =)
        //        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.recycler_view_menu, menu);
        //        return super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.add_item_recycler:
                //                posicion donde se agrega el item
                addRecyclerViewItem(0);
                Toast.makeText(this, "add", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.remove_item_recycler:
                if (mAdapter.getItemCount() >= 1) {
                    removeRecyclerViewItem(mAdapter.getItemCount() - 1);
                } else {
                    Toast.makeText(this, "No hay items para eliminar.", Toast.LENGTH_SHORT).show();
                }
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void addRecyclerViewItem(int position) {
        myDataset.add(position, "added Data " + (++counter));
        mAdapter.notifyItemInserted(position);

        //        hace scroll automatico hasta donde se añadio el item
        mLayoutManager.scrollToPosition(0);
    }

    private void removeRecyclerViewItem(int position) {
        myDataset.remove(position);
        mAdapter.notifyItemRemoved(position);

    }

    private ArrayList<String> getAllNames() {
        return new ArrayList<String>() {{
            add("esteban");
            add("luisa");
            add("juano");
            add("walter");
            add("elizabeth");
        }};
    }

}
