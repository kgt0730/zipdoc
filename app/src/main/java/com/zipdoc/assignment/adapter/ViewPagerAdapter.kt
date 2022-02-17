package com.zipdoc.assignment.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.zipdoc.assignment.view.MainActivity
import com.zipdoc.assignment.view.ViewPagerFragment

class ViewPagerAdapter(mainActivity: MainActivity, imageUrl: Array<String>) :
    FragmentStateAdapter(mainActivity) {

    var imageUrl = imageUrl

    override fun getItemCount(): Int {
        return imageUrl.size
    }

    override fun createFragment(position: Int): Fragment {

        return ViewPagerFragment(imageUrl.get(position))

    }

}