package com.example.postapp.ui.main;

import com.example.postapp.apis.ApiManger;
import com.example.postapp.pojo.PostModel;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {

    public MutableLiveData<List<PostModel>> postMutableLiveData = new MutableLiveData<>(); //can change manually
   public MutableLiveData<PostModel> post = new MutableLiveData<>();
    public void getPosts(){
        ApiManger.getApis().getPosts().enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                postMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {

            }
        });
    }

}
