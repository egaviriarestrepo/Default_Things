package com.example.egaviria.defaultactivities.recycler_view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.egaviria.defaultactivities.R;

import java.util.List;

/**
 * Created by egaviria on 29/10/17.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    private List<String> mDataset;
    private int layout;
    private OnItemClickListener itemClickListener;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;

        public ViewHolder(View v) {
            super(v);
            mTextView = v.findViewById(R.id.recyclerTextView);
        }

        public void bind(final String name, final OnItemClickListener listener){
            mTextView.setText(name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(name, getAdapterPosition());
                }
            });
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    MyRecyclerViewAdapter(List<String> myDataset, int layout, OnItemClickListener listener) {
        this.mDataset = myDataset;
        this.layout = layout;
        this.itemClickListener = listener;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView mTextView;

        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(mDataset.get(position));
        holder.bind(mDataset.get(position), itemClickListener);
    }



    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface OnItemClickListener{
        void onItemClick ( String name, int position);
    }


}
