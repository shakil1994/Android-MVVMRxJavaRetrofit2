package com.blackbirds.shakil.kotlinmvvmrxjavaretrofit2

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blackbirds.shakil.kotlinmvvmrxjavaretrofit2.Adapter.PostListAdapter
import com.blackbirds.shakil.kotlinmvvmrxjavaretrofit2.ViewModel.MainActivityViewModel
import dmax.dialog.SpotsDialog

class MainActivity : AppCompatActivity() {

    var mainActivityViewModel: MainActivityViewModel? = null

    var recyclerPost: RecyclerView? = null
    var adapter: PostListAdapter? = null
    var layoutManager: LinearLayoutManager? = null

    var dialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        dialog = SpotsDialog.Builder().setContext(this).setCancelable(false).build()
        dialog!!.show()

        recyclerPost = findViewById(R.id.recyclerPost)
        layoutManager = LinearLayoutManager(this)
        recyclerPost!!.layoutManager = layoutManager

        mainActivityViewModel!!.getPostList.observe(this, { postModels ->
            Log.e("MainActivity", "PostList: " + postModels.get(0).userId)

            adapter=  PostListAdapter(this, postModels)
            adapter!!.notifyDataSetChanged()
            recyclerPost!!.adapter = adapter
            dialog!!.dismiss()
        })
    }
}