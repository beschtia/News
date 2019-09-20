package com.gmail.davorlukic82.news.networking.interactors

import com.gmail.davorlukic82.news.model.response.ArticlesResponse
import com.gmail.davorlukic82.news.networking.NewsApiService
import retrofit2.Callback

class ArticleInteractorImpl(private val apiService: NewsApiService): ArticleInteractor {

    override fun getArticles(articlesCallback: Callback<ArticlesResponse>) {
        apiService.getArticles().enqueue(articlesCallback)
    }
}