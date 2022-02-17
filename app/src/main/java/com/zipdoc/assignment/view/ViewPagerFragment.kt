package com.zipdoc.assignment.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.zipdoc.assignment.databinding.FragmentViewPagerBinding

class ViewPagerFragment(imageUrl: String) : Fragment() {


    private var fragmentViewPagerBinding: FragmentViewPagerBinding? = null
    var imageUrl = imageUrl

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        fragmentViewPagerBinding = binding

        fragmentViewPagerBinding!!.imageView.bringToFront()

        Glide.with(this)
            .load(imageUrl)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(fragmentViewPagerBinding!!.imageView)

        return fragmentViewPagerBinding!!.root

    }

    override fun onDestroy() {

        fragmentViewPagerBinding = null
        super.onDestroy()

    }

    override fun onLowMemory() {
        super.onLowMemory()
    }
}
