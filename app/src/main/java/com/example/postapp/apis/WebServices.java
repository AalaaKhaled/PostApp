package com.example.postapp.apis;

import com.example.postapp.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WebServices {
    @GET("posts")
    Call<List<PostModel>> getPosts();
    @GET("posts/1")
    Call<PostModel> getPost();

}
