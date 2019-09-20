package com.gmail.davorlukic82.news.networking.interactors

import com.gmail.davorlukic82.news.model.response.ArticlesResponse
import retrofit2.Callback

interface ArticleInteractor {
    fun getArticles(articlesCallback: Callback<ArticlesResponse>)
}