package com.gmail.davorlukic82.news.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Article (
    @PrimaryKey (autoGenerate = true)
    val idDB: Long,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    var receivedTime: Long?
)
