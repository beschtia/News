package com.gmail.davorlukic82.news.model

import com.gmail.davorlukic82.news.persistance.ArticlesRepositoryContract
import com.gmail.davorlukic82.news.ui.activities.ArticlesDetailsActivityContract

class ArticlesDetailsActivityModel(repository: ArticlesRepositoryContract) : ArticlesDetailsActivityContract.ArticlesDetailsActivityModel {

    private val articles = repository.getAllArticles() as ArrayList<Article>

    override fun getArticles(): ArrayList<Article> = articles

    override fun getTitle(position: Int): String? = articles[position].title
}