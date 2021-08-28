package com.blackbirds.shakil.androidmvvmrxjavaretrofit2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blackbirds.shakil.androidmvvmrxjavaretrofit2.Model.PostModel;
import com.blackbirds.shakil.androidmvvmrxjavaretrofit2.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PostListAdapter extends RecyclerView.Adapter<PostListAdapter.MyViewHolder> {

    private Context context;
    private List<PostModel> postModelList;

    public PostListAdapter(Context context, List<PostModel> postModelList) {
        this.context = context;
        this.postModelList = postModelList;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_post_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        holder.txtTitle.setText(String.valueOf(postModelList.get(position).getTitle()));
        holder.txtBody.setText(new StringBuilder(postModelList.get(position).getBody()
                .substring(0, 20)).append("...").toString());
        holder.txtUserId.setText(String.valueOf(postModelList.get(position).getUserId()));
    }

    @Override
    public int getItemCount() {
        return postModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitle, txtBody, txtUserId;

        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtBody = itemView.findViewById(R.id.txtBody);
            txtUserId = itemView.findViewById(R.id.txtUserId);
        }
    }
}
