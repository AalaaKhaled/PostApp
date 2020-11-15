package com.example.postapp.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.postapp.R;
import com.example.postapp.pojo.PostModel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {
    public List<PostModel> posts;

    public PostsAdapter(List<PostModel> posts) {
        this.posts = posts;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item,parent,false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
      PostModel post = posts.get(position);
      holder.body.setText(post.getBody());
      holder.title.setText(post.getTitle());
      holder.userId.setText(post.getUserId()+"");
    }

    @Override
    public int getItemCount() {
        if(posts==null) return 0;
        return posts.size();
    }
    public void changeData(List<PostModel> posts){
        this.posts=posts;
        notifyDataSetChanged();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView body;
        TextView userId;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            body = itemView.findViewById(R.id.body);
            userId = itemView.findViewById(R.id.user_id);

        }
    }
}
