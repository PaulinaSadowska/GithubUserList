package com.nekodev.paulina.sadowska.githubuserlist.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nekodev.paulina.sadowska.githubuserlist.R;
import com.nekodev.paulina.sadowska.githubuserlist.data.DataManager;
import com.nekodev.paulina.sadowska.githubuserlist.model.User;
import com.nekodev.paulina.sadowska.githubuserlist.view.adapters.UserListAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Paulina Sadowska on 14.08.2016.
 */

public class UserListFragment extends Fragment {

    @BindView(R.id.recycler_users)
    RecyclerView mUserList;

    private UserListAdapter mUserListAdapter;
    private DataManager mDataManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserListAdapter = new UserListAdapter(getActivity());
        mDataManager = new DataManager();
    }

    private void populateWithDummyData(List<User> mUsers) {
        String[] avatars = getResources().getStringArray(R.array.dummy_avatars);
        String[] names = getResources().getStringArray(R.array.dummy_names);
        for (int i = 0; i < avatars.length; i++) {
            if(names[i] == null) return;
            mUsers.add(new User(names[i], avatars[i]));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_list, container, false);
        ButterKnife.bind(this, view);
        setupRecyclerView();
        return view;
    }

    private void setupRecyclerView() {
        mUserList.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mUserList.setHasFixedSize(true);
        mUserList.setAdapter(mUserListAdapter);
        mDataManager.setDataReadyListener(new DataManager.DataReadyListener() {
            @Override
            public void dataReady(List<User> users) {
                if(mUserListAdapter!=null){
                    mUserListAdapter.addUsers(users);
                }
            }
        });
        mDataManager.loadData();
    }
}
