package com.gmail.davorlukic82.news.ui.activities

import com.gmail.davorlukic82.news.R
import com.gmail.davorlukic82.news.ui.fragments.NewsFragment

class MainActivity : BaseActivity() {

    override fun getLayoutResourceId() = R.layout.activity_main

    override fun setUpUi() {
        showFragment(NewsFragment.newInstance())
    }

    override fun onResume() {
        super.onResume()
        showFragment(NewsFragment.newInstance())
    }
}
