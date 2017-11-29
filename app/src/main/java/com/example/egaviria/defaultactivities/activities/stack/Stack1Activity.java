package com.example.egaviria.defaultactivities.activities.stack;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.egaviria.defaultactivities.R;

public class Stack1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack1);

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Stack1Activity");
        }

        findViewById(R.id.stackButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Stack1Activity.this, Stack2Activity.class);
                startActivity(intent);
            }
        });

        Toast.makeText(Stack1Activity.this, "onCreate Stack1Activity", Toast.LENGTH_SHORT).show();


    }

    @Override
    protected void onResume() {
        Toast.makeText(Stack1Activity.this, "OnResume Stack1Activity", Toast.LENGTH_SHORT).show();
        super.onResume();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
