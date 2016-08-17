package com.nekodev.paulina.sadowska.githubuserlist.view.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nekodev.paulina.sadowska.githubuserlist.R;
import com.nekodev.paulina.sadowska.githubuserlist.view.fragments.UserListFragment;

/**
 * Created by Paulina Sadowska on 14.08.2016.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actiity_main);
        if ((findViewById(R.id.content_frame) != null && savedInstanceState == null)
                || findViewById(R.id.content_frame) == null)
        {
            addUserListFragment();
        }
    }

    private void addUserListFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, new UserListFragment())
                .commit();
    }
}
