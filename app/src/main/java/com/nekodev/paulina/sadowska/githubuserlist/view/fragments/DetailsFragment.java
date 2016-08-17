package com.nekodev.paulina.sadowska.githubuserlist.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nekodev.paulina.sadowska.githubuserlist.R;

import butterknife.ButterKnife;

/**
 * Created by Paulina Sadowska on 17.08.2016.
 */

public class DetailsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_details, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

}
