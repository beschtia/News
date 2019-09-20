package com.gmail.davorlukic82.news.common

import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.bumptech.glide.Glide
import com.gmail.davorlukic82.news.R

fun FragmentActivity.showFragment(containerId: Int, fragment: Fragment, shouldAddToBackStack: Boolean = false, tag: String = ""){
    supportFragmentManager.beginTransaction().apply {
        if(shouldAddToBackStack){
            addToBackStack(tag)
        }
    }.replace(containerId, fragment).commitAllowingStateLoss()
}

fun ImageView.loadImage(imageUrl: String?) {
    Glide.with(this).load(imageUrl).centerCrop().placeholder(R.drawable.ic_no_image)
        .error(R.drawable.ic_broken_image).fallback(R.drawable.ic_no_image)
        .into(this)
}
