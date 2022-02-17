package com.zipdoc.assignment.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.zipdoc.assignment.R
import com.zipdoc.assignment.adapter.ListAdapter
import com.zipdoc.assignment.data.ImageData
import com.zipdoc.assignment.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {

    lateinit var activityListBinding: ActivityListBinding
    lateinit var imgList: Array<String>
    val mDatas = mutableListOf<ImageData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityListBinding = ActivityListBinding.inflate(layoutInflater)
        setContentView(activityListBinding.root)

        imgList = resources.getStringArray(R.array.zipdoc)

        initRecyclerView()
        initializelist()

    }

    fun initRecyclerView() {

        val adapter = ListAdapter(this)
        adapter.datas = mDatas
        activityListBinding.recycelerView.adapter = adapter
        activityListBinding.recycelerView.layoutManager = LinearLayoutManager(this)

    }

    fun initializelist() {
        with(mDatas) {
            for (img in imgList) {
                add(ImageData(url = img))
            }
        }
    }
}