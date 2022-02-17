package com.zipdoc.assignment.view

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.zipdoc.assignment.R
import com.zipdoc.assignment.adapter.ViewPagerAdapter
import com.zipdoc.assignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var activityMainBinding: ActivityMainBinding

    lateinit var imgList: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var pos = intent.getSerializableExtra("position")

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        imgList = resources.getStringArray(R.array.zipdoc)

        activityMainBinding.viewPager.adapter = ViewPagerAdapter(this, imgList)
        activityMainBinding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        activityMainBinding.viewPager.currentItem = pos as Int

    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
    }
}