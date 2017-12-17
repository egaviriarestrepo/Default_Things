package com.example.egaviria.defaultactivities.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.example.egaviria.defaultactivities.R;

import java.util.Random;

public class ImagesActivity extends AppCompatActivity {

    private ImageView testImageView;
    private int[] images= {R.drawable.img_256x256_1, R.drawable.img_720x1280_1, R.drawable.img_720x1280_2,
    R.drawable.img_720x1280_3, R.drawable.img_720x1280_4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        testImageView = findViewById(R.id.testImageView);
        registerForContextMenu(testImageView);

        testImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int random = new Random().nextInt(5) + 0; // [0, 60] + 20 => [20, 80]
                testImageView.setImageResource(images[random]);
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contex_menu_img_scale, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.scaleCenter:
                testImageView.setScaleType(ImageView.ScaleType.CENTER);
                return true;
            case R.id.scaleCenterCrop:
                testImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                return true;
            case R.id.scaleCenterInside:
                testImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                return true;
            case R.id.scaleFitCenter:
                testImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return true;
            case R.id.scaleFitEnd:
                testImageView.setScaleType(ImageView.ScaleType.FIT_END);
                return true;
            case R.id.scaleFitStart:
                testImageView.setScaleType(ImageView.ScaleType.FIT_START);
                return true;
            case R.id.scaleFitXY:
                testImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                return true;
            case R.id.scaleMatrix:
                testImageView.setScaleType(ImageView.ScaleType.MATRIX);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
