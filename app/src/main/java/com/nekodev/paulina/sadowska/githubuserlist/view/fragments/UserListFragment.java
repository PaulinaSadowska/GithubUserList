package com.nekodev.paulina.sadowska.githubuserlist.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.nekodev.paulina.sadowska.githubuserlist.GitHubUsersApplication;
import com.nekodev.paulina.sadowska.githubuserlist.R;
import com.nekodev.paulina.sadowska.githubuserlist.data.DataManager;
import com.nekodev.paulina.sadowska.githubuserlist.model.User;
import com.nekodev.paulina.sadowska.githubuserlist.view.adapters.UserListAdapter;

import java.io.Serializable;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Paulina Sadowska on 14.08.2016.
 */

public class UserListFragment extends Fragment {

    private static final String SAVED_USERS_KEY = "UsersKey";

    @BindView(R.id.recycler_users)
    RecyclerView mUserList;

    private UserListAdapter mUserListAdapter;
    private DataManager mDataManager;
    private CompositeSubscription mCompositeSubscription = new CompositeSubscription();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserListAdapter = new UserListAdapter(getActivity());
        mDataManager = GitHubUsersApplication.get(getActivity()).getComponent().dataManager();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(SAVED_USERS_KEY, mUserListAdapter.getUsers());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_list, container, false);
        ButterKnife.bind(this, view);
        if(savedInstanceState!=null && savedInstanceState.containsKey(SAVED_USERS_KEY)){
            Serializable users = savedInstanceState.getSerializable(SAVED_USERS_KEY);
            if(users instanceof ArrayList) {
                mUserListAdapter.addUsers((ArrayList)users);
            }
        }
        setupRecyclerView();
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mCompositeSubscription.unsubscribe();
    }

    private void setupRecyclerView() {
        mUserList.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mUserList.setHasFixedSize(true);
        mUserList.setAdapter(mUserListAdapter);
        if(mUserListAdapter.getItemCount() == 0) {
            getUsers();
        }
    }

    private void getUsers(){
        mCompositeSubscription.add(mDataManager.getUsers()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(mDataManager.getScheduler())
                .subscribe(new Subscriber<User>() {
                    @Override
                    public void onCompleted() { }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(getActivity(), R.string.connection_problem, Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(User user) {
                        mUserListAdapter.addUser(user);
                    }
                }));
    }
}
