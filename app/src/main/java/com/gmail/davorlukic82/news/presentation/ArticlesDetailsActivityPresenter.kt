package com.gmail.davorlukic82.news.presentation

import com.gmail.davorlukic82.news.model.Article
import com.gmail.davorlukic82.news.persistance.ArticlesRepositoryContract
import com.gmail.davorlukic82.news.ui.activities.ArticlesDetailsActivityContract

class ArticlesDetailsActivityPresenter(private val view: ArticlesDetailsActivityContract.View,
                                       private val repository: ArticlesRepositoryContract
) : ArticlesDetailsActivityContract.Presenter {

    override fun requestArticles() {
        val news = repository.getAllArticles()
        view.setDataToViewPager(news as ArrayList<Article>)
    }

    override fun requestActionBar(startPosition: Int) {
        val news = repository.getAllArticles()
        view.setActionBar(news[startPosition].title.toString())
    }

    override fun requestTitle(position: Int) {
        val news = repository.getAllArticles()
        view.onRequestTitle(news[position].title.toString())
    }
}