package com.blackbirds.shakil.kotlinmvvmrxjavaretrofit2.Network

import com.blackbirds.shakil.kotlinmvvmrxjavaretrofit2.Model.PostModel
import io.reactivex.Observable
import retrofit2.http.GET

interface APIService {
    @GET("posts")
    fun getPosts(): Observable<MutableList<PostModel>>
}