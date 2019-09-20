package com.gmail.davorlukic82.news.ui.fragments

import com.gmail.davorlukic82.news.model.Article


interface NewsFragmentContract {

    interface View{

        fun onNewsLoaded(news: ArrayList<Article>)

        fun showProgress();

        fun hideProgress();

        fun onResponseFailure(throwable: Throwable)
    }

    interface Presenter{

        fun loadNews()
    }

    interface GetNewsIntractor {

        interface OnFinishedListener {
            fun onFinished(news: ArrayList<Article>)
            fun onFailure(t: Throwable)
        }

        fun getNews(onFinishedListener: OnFinishedListener)
    }
}