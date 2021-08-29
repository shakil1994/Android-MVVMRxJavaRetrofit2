package com.blackbirds.shakil.kotlinmvvmrxjavaretrofit2.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.blackbirds.shakil.kotlinmvvmrxjavaretrofit2.Model.PostModel
import com.blackbirds.shakil.kotlinmvvmrxjavaretrofit2.Repositories.MainRepo

class MainActivityViewModel : ViewModel() {

    private val mainRepo: MainRepo

    init {
        mainRepo = MainRepo()
    }

    val getPostList: LiveData<MutableList<PostModel>>
        get() = mainRepo.getPostModelLiveData
}