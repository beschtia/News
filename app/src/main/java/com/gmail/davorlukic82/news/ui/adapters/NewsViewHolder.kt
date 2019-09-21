package com.gmail.davorlukic82.news.ui.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.gmail.davorlukic82.news.common.loadImage
import com.gmail.davorlukic82.news.model.Article
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_news.view.*
class NewsViewHolder (override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bindData(article: Article, onItemSelected: (Int) -> Unit) {

        containerView.setOnClickListener { onItemSelected(adapterPosition) }

        containerView.articleTitle.text = article.title
        containerView.articleImage.loadImage(article.urlToImage)

    }
}