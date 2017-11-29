package com.example.egaviria.defaultactivities.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.egaviria.defaultactivities.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by egaviria on 29/10/17.
 */

public class myCustomAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<String> Title;
    private boolean isGrid = false;
    private int[] androidDrawables = {android.R.drawable.ic_menu_add, android.R.drawable.ic_popup_disk_full, android.R.drawable
            .ic_menu_gallery, android.R.drawable.alert_dark_frame, android.R.drawable.arrow_down_float, android.R.drawable
            .btn_default, android.R.drawable.btn_radio, android.R.drawable.btn_star_big_off, android.R.drawable
            .button_onoff_indicator_on, android.R.drawable.editbox_dropdown_dark_frame, android.R.drawable.zoom_plate, android
            .R.drawable.toast_frame, android.R.drawable.sym_call_outgoing, android.R.drawable.stat_sys_upload, android.R
            .drawable.stat_notify_sync_noanim};

    public myCustomAdapter(Context mContext, String[] title) {
        this.mContext = mContext;
        Title = new ArrayList<>(Arrays.asList(title));
    }

    public myCustomAdapter(Context mContext, ArrayList<String> title) {
        this.mContext = mContext;
        //        Title = title.toArray(new String[title.size()]);
        Title = title;
    }

    public myCustomAdapter(Context mContext, ArrayList<String> title, boolean isGrid) {
        this.mContext = mContext;
        //        Title = title.toArray(new String[title.size()]);
        this.Title = title;

        if(isGrid) {
            this.isGrid = isGrid;
        }
    }

    @Override
    public int getCount() {
        return Title.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {


        LayoutInflater mLayoutInflater = LayoutInflater.from(mContext);
        if(isGrid){
            view = mLayoutInflater.inflate(R.layout.layout_grid_view, null);
        }else{
            view = mLayoutInflater.inflate(R.layout.custom_list_view_layout, null);
        }
        String currName = Title.get(position);
        TextView mTextView = view.findViewById(R.id.txtTitle);
        ImageView mImageView = view.findViewById(R.id.imgIcon);
        mTextView.setText(currName);

        Random rand = new Random();

        int  n = rand.nextInt(androidDrawables.length - 1);

        mImageView.setImageResource(androidDrawables[n]);

        return view;
    }
}
