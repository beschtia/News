package com.gmail.davorlukic82.news.model.response

import com.gmail.davorlukic82.news.model.Article
import com.google.gson.annotations.SerializedName

data class ArticlesResponse (@SerializedName("articles") val articles: ArrayList<Article>)