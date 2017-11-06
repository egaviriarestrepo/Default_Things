package com.example.egaviria.defaultactivities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.egaviria.defaultactivities.activities.CardViewActivity;
import com.example.egaviria.defaultactivities.activities.DefaultActivities;
import com.example.egaviria.defaultactivities.activities.GridViewActivity;
import com.example.egaviria.defaultactivities.activities.ListViewActivity;
import com.example.egaviria.defaultactivities.activities.WidgetsActivity;
import com.example.egaviria.defaultactivities.recycler_view.RecyclerCardViewActivity;
import com.example.egaviria.defaultactivities.recycler_view.RecyclerViewActivity;

import static com.example.egaviria.defaultactivities.Utils.Utils.screenDPI;

public class StartActivity extends Activity {

    private Button defaultActivitiesButton;
    private Button sizeAndDpiButton;
    private final Context self = StartActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_start);

        bindUI();
        screenDPI(this);

        Toast.makeText(this, "On create StartAvtivity", Toast.LENGTH_SHORT).show();


    }

    private void bindUI() {
        defaultActivitiesButton = findViewById(R.id.defaultActivitiesButton);
        sizeAndDpiButton = findViewById(R.id.sizeAndDpiButton);

        defaultActivitiesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(self, DefaultActivities.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.widgetsButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(self, WidgetsActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.listViewButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(self, ListViewActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.gridViewButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(self, GridViewActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.recyclerViewButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(self, RecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.recyclerCardViewButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(self, RecyclerCardViewActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.cardViewButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(self, CardViewActivity.class);
                startActivity(intent);
            }
        });

        sizeAndDpiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screenDPI(self);
            }
        });
    }


}
