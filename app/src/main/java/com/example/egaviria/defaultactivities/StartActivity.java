package com.example.egaviria.defaultactivities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.egaviria.defaultactivities.activities.FragmentActivity;
import com.example.egaviria.defaultactivities.activities.dpiPxActivity;
import com.example.egaviria.defaultactivities.activities.stack.Stack1Activity;
import com.example.egaviria.defaultactivities.libraries_activity.LibreariesActivity;
import com.example.egaviria.defaultactivities.activities.CardViewActivity;
import com.example.egaviria.defaultactivities.activities.DefaultActivities;
import com.example.egaviria.defaultactivities.activities.GridViewActivity;
import com.example.egaviria.defaultactivities.activities.ListViewActivity;
import com.example.egaviria.defaultactivities.activities.WidgetsActivity;
import com.example.egaviria.defaultactivities.recycler_view.RecyclerCardViewActivity;
import com.example.egaviria.defaultactivities.recycler_view.RecyclerViewActivity;
import com.example.egaviria.defaultactivities.view_pager_slides.SlideViewPagerActivity;

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

        findViewById(R.id.fragmentsButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(self, FragmentActivity.class);
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

        findViewById(R.id.slidesViewPagerButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(self, SlideViewPagerActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.librariesViewButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(self, LibreariesActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.dpiPxButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(self, dpiPxActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.stackButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(self, Stack1Activity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.imgButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(self, Stack1Activity.class);
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
