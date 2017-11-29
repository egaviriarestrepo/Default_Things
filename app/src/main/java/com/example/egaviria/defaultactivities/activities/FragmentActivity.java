package com.example.egaviria.defaultactivities.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.egaviria.defaultactivities.R;
import com.example.egaviria.defaultactivities.fragments.DataFragment;
import com.example.egaviria.defaultactivities.fragments.DetailsFragment;

public class FragmentActivity extends AppCompatActivity implements DetailsFragment.OnFragmentInteractionListener, DataFragment.DataListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Toast.makeText(this, "onFragmentInteraction" + uri.toString(), Toast.LENGTH_SHORT).show();
    }


    @Override
    public void sendData(String textToSend) {

        DetailsFragment mDetailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.myFragment2);

        mDetailsFragment.renderText(textToSend);

    }
}
