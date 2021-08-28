package com.blackbirds.shakil.androidmvvmrxjavaretrofit2.Repositroies;

import androidx.lifecycle.MutableLiveData;

import com.blackbirds.shakil.androidmvvmrxjavaretrofit2.Common.Common;
import com.blackbirds.shakil.androidmvvmrxjavaretrofit2.Model.PostModel;
import com.blackbirds.shakil.androidmvvmrxjavaretrofit2.Network.APIService;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainRepo {
    private static final String TAG = "MainRepo";

    private APIService apiService;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public MainRepo() {
        this.apiService = Common.getAPIService();
    }

    public MutableLiveData<List<PostModel>> getPostModelLiveData(){
        MutableLiveData<List<PostModel>> data = new MutableLiveData<>();

        compositeDisposable.add(apiService.getPosts()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(postModels -> {
            if (postModels != null){
                data.setValue(postModels);
            }
        }));

        return data;
    }
}
