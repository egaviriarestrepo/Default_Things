package com.example.egaviria.defaultactivities.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.egaviria.defaultactivities.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DataFragment extends Fragment {


    private EditText mEditText;
    private Button mButton;
    private DataListener callback;

    public DataFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof DataFragment.DataListener) {
            callback = (DataListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement DataListener");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View mView = inflater.inflate(R.layout.fragment_data, container, false);

        mEditText = mView.findViewById(R.id.etFragment1);
        mButton = mView.findViewById(R.id.btnFragment1);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendText(mEditText.getText().toString());
            }
        });

        return mView;
    }

    private void sendText (String textToSend){
        callback.sendData(textToSend);
    }

    public interface DataListener {
        void sendData(String textToSend);
    }

}
