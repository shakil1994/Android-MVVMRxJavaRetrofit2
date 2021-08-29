package com.blackbirds.shakil.kotlinmvvmrxjavaretrofit2.Common

import com.blackbirds.shakil.kotlinmvvmrxjavaretrofit2.Network.APIService
import com.blackbirds.shakil.kotlinmvvmrxjavaretrofit2.Network.RetrofitClient

object Common {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    val getAPIService: APIService
    get() = RetrofitClient.getRetrofitClient(BASE_URL).create(APIService::class.java)
}