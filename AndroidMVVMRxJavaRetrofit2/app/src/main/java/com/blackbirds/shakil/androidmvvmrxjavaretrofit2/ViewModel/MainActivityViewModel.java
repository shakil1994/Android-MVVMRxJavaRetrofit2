package com.blackbirds.shakil.androidmvvmrxjavaretrofit2.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.blackbirds.shakil.androidmvvmrxjavaretrofit2.Model.PostModel;
import com.blackbirds.shakil.androidmvvmrxjavaretrofit2.Repositroies.MainRepo;

import java.util.List;

public class MainActivityViewModel extends ViewModel {
    private final MainRepo mainRepo;

    public MainActivityViewModel() {
        mainRepo = new MainRepo();
    }

    public LiveData<List<PostModel>> getPostList(){
        return mainRepo.getPostModelLiveData();
    }
}
