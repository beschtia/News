package com.gmail.davorlukic82.news.persistance

import com.gmail.davorlukic82.news.model.Article

interface ArticlesRepositoryContract {

    fun saveArticle(article: Article)
    fun getAllArticles(): List<Article>
    fun deleteAllArticles()
}