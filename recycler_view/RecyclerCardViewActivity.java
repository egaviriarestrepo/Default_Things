package com.example.egaviria.defaultactivities.recycler_view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.egaviria.defaultactivities.R;
import com.example.egaviria.defaultactivities.class_items.Film;

import java.util.ArrayList;
import java.util.List;

public class RecyclerCardViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerCardView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Film> myFilms;

    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_card_view);

        bindUI();
    }

    private void bindUI() {
        myFilms = this.getAllMovies();

        mRecyclerCardView = findViewById(R.id.myRecyclerCardView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        //        mRecyclerCardView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        //        mLayoutManager = new GridLayoutManager(this, 2);
        //        mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        // specify an adapter (see also next example)
        mAdapter = new MyCardRecyclerViewAdapter(myFilms, R.layout.card_recycler_view_layout, new MyCardRecyclerViewAdapter
                .OnItemClickListener() {
            @Override
            public void onItemClick(Film film, int position) {

                removeRecyclerViewItem(position);
                //                Toast.makeText(RecyclerViewActivity.this, "el nombre es: " + name + "la posicion es: " +
                // position, Toast
                //                        .LENGTH_SHORT).show();
            }
        });


        //        si estamos seguros que el tamaño de nuestro layout no va a cambiar. Mejora bastante el rendimiento
        mRecyclerCardView.setHasFixedSize(true);

        //        añade una anumacion por defecto =)
        //        mRecyclerCardView.setItemAnimator(new DefaultItemAnimator());

        mRecyclerCardView.setLayoutManager(mLayoutManager);
        mRecyclerCardView.setAdapter(mAdapter);

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
        myFilms.add(position, new Film("added Film " + (++counter), R.drawable.newmovie));
        mAdapter.notifyItemInserted(position);

        //        hace scroll automatico hasta donde se añadio el item
        mLayoutManager.scrollToPosition(0);

    }

    private void removeRecyclerViewItem(int position) {
        myFilms.remove(position);
        mAdapter.notifyItemRemoved(position);
    }

    private ArrayList<Film> getAllMovies() {
        return new ArrayList<Film>() {{
            add(new Film("Ben Hurt", R.drawable.benhur));
            add(new Film("Deadpool", R.drawable.deadpool));
            add(new Film("Guardians of galaxy", R.drawable.guardians));
            add(new Film("Warcraft", R.drawable.warcraft));
        }};
    }

}