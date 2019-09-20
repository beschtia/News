package com.gmail.davorlukic82.news.persistance

import com.gmail.davorlukic82.news.App
import com.gmail.davorlukic82.news.database.ArticlesDatabase
import com.gmail.davorlukic82.news.model.Article
import java.util.*

class ArticlesRepository: ArticlesRepositoryContract {

    private var db = ArticlesDatabase.getInstance(App.getAppContext())

    private var articlesDao = db.articlesDao()

    fun nesto(){
        TODO("pogledaj")
    }

    /*override fun saveArticle(article: Article) {
        val timeNow = Calendar.getInstance().timeInMillis
        val modifiedArticle = Article(
            title = article.title,
            description = article.description,
            url = article.url,
            urlToImage = article.urlToImage,
            publishedAt = article.publishedAt,
            receivedTime = timeNow
        )
        articlesDao.addArticle(modifiedArticle)
    }*/

    override fun saveArticle(article: Article) {
        article.receivedTime = Calendar.getInstance().timeInMillis
        articlesDao.addArticle(article)
    }

    override fun getAllArticles(): List<Article> = articlesDao.getArticles()

    override fun deleteAllArticles() {
        articlesDao.deleteArticles()
    }
}