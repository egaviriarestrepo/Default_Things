package com.example.egaviria.defaultactivities.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.egaviria.defaultactivities.R;

public class DefaultActivities extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        checkDpi();

        final Button basicActivity = (Button) findViewById(R.id.basicActivity);

        basicActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentGOBasic = new Intent(DefaultActivities.this, com.example.egaviria.defaultactivities.default_activities.basicActivity.class);
                startActivity(intentGOBasic);
            }
        });

        final Button buttonNavActivity = (Button) findViewById(R.id.buttonNavActivity);

        buttonNavActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentGOBasic = new Intent(DefaultActivities.this, com.example.egaviria.defaultactivities.default_activities.buttonNavActivity.class);
                startActivity(intentGOBasic);
            }
        });

        final Button FullscreenActivity = (Button) findViewById(R.id.FullscreenActivity);

        FullscreenActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentGOBasic = new Intent(DefaultActivities.this, com.example.egaviria.defaultactivities.default_activities.FullscreenActivity.class);
                startActivity(intentGOBasic);
            }
        });

        final Button LoginActivity = (Button) findViewById(R.id.LoginActivity);

        LoginActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentGOBasic = new Intent(DefaultActivities.this, com.example.egaviria.defaultactivities.default_activities.LoginActivity.class);
                startActivity(intentGOBasic);
            }
        });

        final Button ItemDetailActivity = (Button) findViewById(R.id.ItemDetailActivity);

        ItemDetailActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentGOBasic = new Intent(DefaultActivities.this, com.example.egaviria.defaultactivities.default_activities.ItemDetailActivity.class);
                startActivity(intentGOBasic);
            }
        });

        final Button navDrawerActivity = (Button) findViewById(R.id.navDrawerActivity);

        navDrawerActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentGOBasic = new Intent(DefaultActivities.this, com.example.egaviria.defaultactivities.default_activities.navDrawerActivity.class);
                startActivity(intentGOBasic);
            }
        });

        final Button ScrollingActivity = (Button) findViewById(R.id.ScrollingActivity);

        ScrollingActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentGOBasic = new Intent(DefaultActivities.this, com.example.egaviria.defaultactivities.default_activities.ScrollingActivity.class);
                startActivity(intentGOBasic);
            }
        });

        final Button SettingsActivity = (Button) findViewById(R.id.SettingsActivity);

        SettingsActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentGOBasic = new Intent(DefaultActivities.this, com.example.egaviria.defaultactivities.default_activities.SettingsActivity.class);
                startActivity(intentGOBasic);
            }
        });

        final Button tabActivity = (Button) findViewById(R.id.tabActivity);

        tabActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentGOBasic = new Intent(DefaultActivities.this, com.example.egaviria.defaultactivities.default_activities.tabActivity.class);
                startActivity(intentGOBasic);
            }
        });
    }

    private void checkDpi() {
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int densityDpi = (int) (metrics.density * 160f);
        Toast.makeText(this, Integer.toString(densityDpi), Toast.LENGTH_LONG).show();
    }

}
