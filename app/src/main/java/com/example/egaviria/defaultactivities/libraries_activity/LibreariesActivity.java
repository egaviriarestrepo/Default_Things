package com.example.egaviria.defaultactivities.libraries_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.egaviria.defaultactivities.R;
import com.example.egaviria.defaultactivities.libraries_activity.view_page_transformer_package.ViewPageTransformerActivity;

public class LibreariesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_librearies);

        findViewById(R.id.viewPagerTransformerButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LibreariesActivity.this, ViewPageTransformerActivity.class);
                startActivity(intent);
            }
        });

    }
}
