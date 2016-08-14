package com.nekodev.paulina.sadowska.githubuserlist.data;


import com.nekodev.paulina.sadowska.githubuserlist.data.remote.GitHubService;
import com.nekodev.paulina.sadowska.githubuserlist.data.remote.RetrofitHelper;
import com.nekodev.paulina.sadowska.githubuserlist.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Paulina Sadowska on 14.08.2016.
 */

public class DataManager implements Callback<List<User>> {
    private GitHubService mGitHubService;
    private DataReadyListener listener;

    public DataManager(){
        mGitHubService = new RetrofitHelper().newHackerNewsService();
    }

    public void loadData(){
        Call<List<User>> call = mGitHubService.getUsers();
        call.enqueue(this);
    }

    public void setDataReadyListener(DataReadyListener listener) {
        this.listener = listener;
    }

    @Override
    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
        if(listener!=null){
            listener.dataReady(response.body());
        }
    }

    @Override
    public void onFailure(Call<List<User>> call, Throwable t) {
        t.printStackTrace();
    }

    public interface DataReadyListener{
        void dataReady(List<User> users);
    }
}
