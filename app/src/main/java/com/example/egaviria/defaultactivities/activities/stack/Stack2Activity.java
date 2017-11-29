package com.example.egaviria.defaultactivities.activities.stack;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.egaviria.defaultactivities.R;

public class Stack2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

        Toast.makeText(Stack2Activity.this, "onCreate Stack2Activity", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onResume() {
        Toast.makeText(Stack2Activity.this, "OnResume Stack2Activity", Toast.LENGTH_SHORT).show();
        super.onResume();
    }

}
