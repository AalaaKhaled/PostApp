package com.example.postapp.apis;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManger {
    private static Retrofit retrofit;
    private static Retrofit getInstance(){
        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static WebServices getApis(){
        return getInstance().create(WebServices.class);
    }

}
