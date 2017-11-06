package com.example.egaviria.defaultactivities.recycler_view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.egaviria.defaultactivities.R;
import com.example.egaviria.defaultactivities.class_items.Film;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by egaviria on 31/10/17.
 */

class MyCardRecyclerViewAdapter extends RecyclerView.Adapter<MyCardRecyclerViewAdapter.ViewHolderMovie> {
    private List<Film> mDataset;
    private MyCardRecyclerViewAdapter.OnItemClickListener itemClickListener;
    private Context ctx;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    class ViewHolderMovie extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView mTextView;
        ImageView mImageView;

        ViewHolderMovie(View v) {
            super(v);
            mTextView = v.findViewById(R.id.movieTextView);
            mImageView = v.findViewById(R.id.movieImageView);
        }

        void bind(final Film film, final MyCardRecyclerViewAdapter.OnItemClickListener listener){
            mTextView.setText(film.getName());

//            Picasso.with(ctx).load(film.getPoster()).fit().into(mImageView);


            mImageView.setImageResource(film.getPoster());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(film, getAdapterPosition());
                }
            });
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    MyCardRecyclerViewAdapter(List<Film> myDataset, int layout, MyCardRecyclerViewAdapter.OnItemClickListener listener) {
        this.mDataset = myDataset;
        this.itemClickListener = listener;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolderMovie onCreateViewHolder(ViewGroup parent, int viewType) {

        if (ctx == null){
            ctx = parent.getContext();
        }

        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_recycler_view_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolderMovie vh = new ViewHolderMovie(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolderMovie holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
//        holder.mTextView.setText("lalal");
//        holder.mImageView.setImageResource(R.drawable.benhur);

        holder.bind(mDataset.get(position), itemClickListener);
    }



    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface OnItemClickListener{
        void onItemClick (Film film, int position);
    }


}
