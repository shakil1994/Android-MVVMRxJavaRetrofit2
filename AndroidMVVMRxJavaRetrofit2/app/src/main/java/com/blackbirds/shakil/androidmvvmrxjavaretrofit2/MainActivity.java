package com.blackbirds.shakil.androidmvvmrxjavaretrofit2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;

import com.blackbirds.shakil.androidmvvmrxjavaretrofit2.Adapter.PostListAdapter;
import com.blackbirds.shakil.androidmvvmrxjavaretrofit2.ViewModel.MainActivityViewModel;

import dmax.dialog.SpotsDialog;

public class MainActivity extends AppCompatActivity {

    MainActivityViewModel mainActivityViewModel;

    RecyclerView recyclerPostList;
    PostListAdapter adapter;
    LinearLayoutManager layoutManager;
    AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        dialog = new SpotsDialog.Builder().setContext(this).setCancelable(false).build();
        dialog.show();

        recyclerPostList = findViewById(R.id.recyclerPostList);
        layoutManager = new LinearLayoutManager(this);
        recyclerPostList.setLayoutManager(layoutManager);

        mainActivityViewModel.getPostList().observe(this, postModels -> {
            Log.e("MainActivity", "Post: " + postModels.get(0).getUserId());

            adapter = new PostListAdapter(this, postModels);
            adapter.notifyDataSetChanged();
            recyclerPostList.setAdapter(adapter);
            dialog.dismiss();
        });
    }
}