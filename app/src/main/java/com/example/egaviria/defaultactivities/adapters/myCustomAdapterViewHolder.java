package com.example.egaviria.defaultactivities.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.egaviria.defaultactivities.R;

public class myCustomAdapterViewHolder extends BaseAdapter {

    private Context mContext;
    private String[] Title;
    private int[] imge;

    public myCustomAdapterViewHolder(Context context, String[] text1, int[] imageIds) {
        mContext = context;
        Title = text1;
        imge = imageIds;
    }

    public int getCount() {
        // TODO Auto-generated method stub
        return Title.length;
    }

    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {

            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.custom_list_view_layout, parent, false);

            holder = new ViewHolder();

            holder.personImageView = convertView.findViewById(R.id.imgIcon);
            holder.nameTextView = convertView.findViewById(R.id.txtTitle);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String currName = Title[position];
        holder.nameTextView.setText(currName);
        holder.personImageView.setImageResource(imge[position%4]);

        return convertView;
    }

    private static class ViewHolder {
        private TextView nameTextView;
        private ImageView personImageView;
    }

}
