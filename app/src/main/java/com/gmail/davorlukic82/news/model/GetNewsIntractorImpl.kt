package com.gmail.davorlukic82.news.model

import com.gmail.davorlukic82.news.model.response.ArticlesResponse
import com.gmail.davorlukic82.news.networking.BackendFactory
import com.gmail.davorlukic82.news.persistance.ArticlesRepository
import com.gmail.davorlukic82.news.ui.fragments.NewsFragmentContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.collections.ArrayList

class GetNewsIntractorImpl : NewsFragmentContract.GetNewsIntractor {

    private val repository = ArticlesRepository()
    val interactor by lazy { BackendFactory.getArticleInteractor() }
    private lateinit var news: ArrayList<Article>
    private lateinit var onFinishedListener: NewsFragmentContract.GetNewsIntractor.OnFinishedListener

    override fun getNews(onFinishedListener: NewsFragmentContract.GetNewsIntractor.OnFinishedListener) {
        this.onFinishedListener = onFinishedListener
        news = repository.getAllArticles() as ArrayList
        checkList(news)
    }

    private fun checkList(dbData: java.util.ArrayList<Article>) {
        var diffInMinutes:Long = 0
        if (dbData.isNotEmpty()) {
            val timeNow = Calendar.getInstance().timeInMillis
            val diff = timeNow - dbData[0].receivedTime!!
            diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(diff)
        }
        if (dbData.isEmpty() || diffInMinutes >= 2) {
            interactor.getArticles(getArticleCallback())
        } else {
            onFinishedListener.onFinished(news)
        }
    }

    private fun getArticleCallback(): Callback<ArticlesResponse> = object : Callback<ArticlesResponse>{
        override fun onFailure(call: Call<ArticlesResponse>, t: Throwable) {
            onFinishedListener.onFailure(t)
        }

        override fun onResponse(
            call: Call<ArticlesResponse>,
            response: Response<ArticlesResponse>
        ) {
            response.body()?.articles?.run {
                repository.deleteAllArticles()
                this.forEach { repository.saveArticle(it) }
                news = repository.getAllArticles() as ArrayList<Article>
                onFinishedListener.onFinished(news)
            }
        }
    }
}