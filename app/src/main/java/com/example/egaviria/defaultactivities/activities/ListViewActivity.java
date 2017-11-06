package com.example.egaviria.defaultactivities.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.egaviria.defaultactivities.R;
import com.example.egaviria.defaultactivities.adapters.myCustomAdapter;
import com.example.egaviria.defaultactivities.adapters.myCustomAdapterViewHolder;

public class ListViewActivity extends AppCompatActivity {

    private ListView myListView;
    private ListView noViewHolderListView;
    private ListView listView1;
    private String[] imProtocols;
    private String[] imPhoneTypes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);

        bindUI();
        adapterAndroid();
        adapterCustomViewHolder();
        adapterCustom();

    }

    private String[] concat(String[] A, String[] B) {
        int aLen = A.length;
        int bLen = B.length;
        String[] C = new String[aLen + bLen];
        System.arraycopy(A, 0, C, 0, aLen);
        System.arraycopy(B, 0, C, aLen, bLen);
        return C;
    }

    private void adapterCustom() {
        String[] textString = concat(imProtocols, imPhoneTypes);

        myCustomAdapter adapter = new myCustomAdapter(this, textString);
        noViewHolderListView.setAdapter(adapter);
    }


    private void adapterCustomViewHolder() {
        String[] textString = concat(imProtocols, imPhoneTypes);
        int[] drawableIds = {android.R.drawable.ic_media_ff, android.R.drawable.ic_menu_gallery, android.R.drawable
                .ic_popup_disk_full, android.R.drawable.ic_menu_add};

        myCustomAdapterViewHolder adapter = new myCustomAdapterViewHolder(this, textString, drawableIds);
        listView1.setAdapter(adapter);
    }

    private void adapterAndroid() {
        final String[] textString = concat(imProtocols, imPhoneTypes);
        ArrayAdapter<String> myAdarper = new ArrayAdapter<>(ListViewActivity.this, android.R.layout.simple_list_item_1,
                textString);

        myListView.setAdapter(myAdarper);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this, "Click on: " + textString[position] + " Position: " + Integer.toString
                        (position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void bindUI() {
        imProtocols = this.getResources().getStringArray(android.R.array.imProtocols);
        imPhoneTypes = this.getResources().getStringArray(android.R.array.phoneTypes);

        myListView = findViewById(R.id.myListView);
        noViewHolderListView = findViewById(R.id.noViewHolderListView);
        listView1 = findViewById(R.id.menuList);
    }
}

