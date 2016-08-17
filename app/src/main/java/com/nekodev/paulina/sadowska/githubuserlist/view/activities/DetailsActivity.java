package com.nekodev.paulina.sadowska.githubuserlist.view.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nekodev.paulina.sadowska.githubuserlist.R;
import com.nekodev.paulina.sadowska.githubuserlist.view.fragments.DetailsFragment;

/**
 * Created by Paulina Sadowska on 17.08.2016.
 */

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        if ((findViewById(R.id.content_frame) != null && savedInstanceState == null)
                || findViewById(R.id.content_frame) == null)
        {
            addUserDetailsFragment();
        }
    }

    private void addUserDetailsFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, new DetailsFragment())
                .commit();
    }
}
