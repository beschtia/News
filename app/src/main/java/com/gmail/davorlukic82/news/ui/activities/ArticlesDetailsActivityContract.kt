package com.gmail.davorlukic82.news.ui.activities

import com.gmail.davorlukic82.news.model.Article

interface ArticlesDetailsActivityContract {

    interface View{

        fun setDataToViewPager(news: ArrayList<Article>)

        fun setActionBar(title: String)

        fun onRequestTitle(title: String)

    }

    interface Presenter{

        fun requestArticles()

        fun requestActionBar(startPosition : Int)

        fun requestTitle(position: Int)
    }


}