package com.nekodev.paulina.sadowska.githubuserlist.view.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.nekodev.paulina.sadowska.githubuserlist.GitHubUsersApplication;
import com.nekodev.paulina.sadowska.githubuserlist.R;
import com.nekodev.paulina.sadowska.githubuserlist.data.DataManager;
import com.nekodev.paulina.sadowska.githubuserlist.databinding.FragmentUserDetailsBinding;
import com.nekodev.paulina.sadowska.githubuserlist.model.UserDetails;
import com.nekodev.paulina.sadowska.githubuserlist.util.MockModelUtil;
import com.nekodev.paulina.sadowska.githubuserlist.viewmodel.UserDetailsViewModel;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Paulina Sadowska on 17.08.2016.
 */

public class DetailsFragment extends Fragment {

    private CompositeSubscription mCompositeSubscription = new CompositeSubscription();
    private DataManager mDataManager;
    private FragmentUserDetailsBinding mUserDetailsBinding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataManager = GitHubUsersApplication.get(getActivity()).getComponent().dataManager();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         mUserDetailsBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_user_details,
                container,
                false);
        getUserDetails();
        return mUserDetailsBinding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mCompositeSubscription.unsubscribe();
    }

    private void getUserDetails(){
        mCompositeSubscription.add(mDataManager.getUserDetails(MockModelUtil.DUMMY_LOGIN) //TODO - change
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(mDataManager.getScheduler())
                .subscribe(new Subscriber<UserDetails>() {
                    @Override
                    public void onCompleted() { }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(getActivity(), R.string.connection_problem, Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(UserDetails userDetails) {
                        mUserDetailsBinding.setViewModel(
                                new UserDetailsViewModel(getActivity(), userDetails)
                        );
                    }
                }));
    }
}
