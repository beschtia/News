package com.gmail.davorlukic82.news.presentation

import com.gmail.davorlukic82.news.ui.activities.ArticlesDetailsActivityContract

class ArticlesDetailsActivityPresenter(private val view: ArticlesDetailsActivityContract.View,
                                       private val articlesDetailsActivityModel: ArticlesDetailsActivityContract.ArticlesDetailsActivityModel
) : ArticlesDetailsActivityContract.Presenter{

    override fun requestArticles() {
        view.setDataToViewPager(articlesDetailsActivityModel.getArticles())
    }

    override fun requestActionBar(startPosition: Int) {
        view.setActionBar(articlesDetailsActivityModel.getTitle(startPosition))
    }

    override fun requestTitle(position: Int) {
        view.onRequestTitle(articlesDetailsActivityModel.getTitle(position))
    }

}