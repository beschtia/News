package com.gmail.davorlukic82.news.presentation

import com.gmail.davorlukic82.news.model.Article
import com.gmail.davorlukic82.news.ui.fragments.NewsFragmentContract
import kotlin.collections.ArrayList

class NewsFragmentPresenter(private val view: NewsFragmentContract.View,
                            private val getNewsIntractor: NewsFragmentContract.GetNewsIntractor)
    : NewsFragmentContract.Presenter, NewsFragmentContract.GetNewsIntractor.OnFinishedListener {

    override fun loadNews() {
        view.showProgress()
        getNewsIntractor.getNews(this)
    }

    override fun onFinished(news: ArrayList<Article>) {
        view.onNewsLoaded(news)
        view.hideProgress()
    }

    override fun onFailure(t: Throwable) {
        view.onResponseFailure(t)
        view.hideProgress()
    }
}