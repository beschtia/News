package com.gmail.davorlukic82.news.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.gmail.davorlukic82.news.model.Article

@Dao
interface ArticlesDao {

    @Insert(onConflict = REPLACE)
    fun addArticle(article: Article)

    @Query("DELETE FROM Article")
    fun deleteArticles()

    @Query("SELECT * FROM Article")
    fun getArticles(): List<Article>
}