package com.example.postapp.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.postapp.R;
import com.example.postapp.apis.ApiManger;
import com.example.postapp.pojo.PostModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    PostViewModel postViewModel;
    RecyclerView recyclerView;
    PostsAdapter postAdapter;
    List<PostModel> posts;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    recyclerView = findViewById(R.id.recyclerView);
    progressBar = findViewById(R.id.progress_bar);

    posts = new ArrayList<>();


    postViewModel = new ViewModelProvider(this).get(PostViewModel.class);
    postViewModel.getPosts();
    postAdapter=new PostsAdapter(posts);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setAdapter(postAdapter);
    postViewModel.postMutableLiveData.observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                posts = postModels;
                postAdapter.changeData(posts);
                progressBar.setVisibility(View.GONE);
            }
        });
    }


}
