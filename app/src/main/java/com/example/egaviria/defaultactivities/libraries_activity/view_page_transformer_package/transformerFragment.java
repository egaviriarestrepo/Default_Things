package com.example.egaviria.defaultactivities.libraries_activity.view_page_transformer_package;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.egaviria.defaultactivities.R;

public class transformerFragment extends Fragment {
    // Store instance variables
    private String title;
    private int page;

    // newInstance constructor for creating fragment with arguments
    public static transformerFragment newInstance(int page, String title) {
        transformerFragment fragmentFirst = new transformerFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        TextView tvLabel = (TextView) view.findViewById(R.id.tvLabel1);
        tvLabel.setText(page + " -- " + title);

        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.fragmentLayoutLinear);

        if(page %2 == 0){
            linearLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
            tvLabel.setTextColor(getResources().getColor(android.R.color.black));
        }else{
            linearLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_purple));
        }

        return view;
    }
}
