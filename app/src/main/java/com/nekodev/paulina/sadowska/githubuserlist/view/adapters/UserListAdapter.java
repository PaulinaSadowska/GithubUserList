package com.nekodev.paulina.sadowska.githubuserlist.view.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.nekodev.paulina.sadowska.githubuserlist.databinding.UserListItemBinding;
import com.nekodev.paulina.sadowska.githubuserlist.model.User;
import com.nekodev.paulina.sadowska.githubuserlist.viewmodel.UserViewModel;
import com.nekodev.paulina.sadowska.githubuserlist.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paulina Sadowska on 14.08.2016.
 */

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.BindingHolder> {

    private List<User> mUsers;
    private Context mContext;

    public UserListAdapter(Context mContext){
        this.mContext = mContext;
        this.mUsers = new ArrayList<>();
    }


    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        UserListItemBinding postBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.user_list_item,
                parent,
                false);
        return new BindingHolder(postBinding);
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        UserListItemBinding postBinding = holder.binding;
        postBinding.setViewModel(new UserViewModel(mContext, mUsers.get(position)));

    }

    public void addUsers(List <User> users){
        this.mUsers = users;
        notifyDataSetChanged();
    }

    public void addUser(User user){
        this.mUsers.add(user);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public static class BindingHolder extends RecyclerView.ViewHolder {
        private UserListItemBinding binding;

        public BindingHolder(UserListItemBinding binding) {
            super(binding.cardView);
            this.binding = binding;
        }
    }
}
