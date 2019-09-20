package com.gmail.davorlukic82.news.ui.fragments

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.View
import com.gmail.davorlukic82.news.R
import com.gmail.davorlukic82.news.common.loadImage
import com.gmail.davorlukic82.news.model.Article
import kotlinx.android.synthetic.main.fragment_article.*

class ArticleFragment : BaseFragment() {

    override fun getLayoutResourceId() = R.layout.fragment_article

    companion object {

        fun newInstance(article: Article): ArticleFragment {
            val args = Bundle()

            args.putString("IMAGE", article.urlToImage)
            args.putString("TITLE", article.title)
            args.putString("DESCRIPTION", article.description)
            args.putString("URL", article.url)

            val fragment = ArticleFragment()
            fragment.arguments = args

            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initUi() {
        val args = arguments
        detailsTitle.text = args!!.getString("TITLE","")
        detailsDescription.text = args.getString("DESCRIPTION")
        detailsImage.loadImage(args.getString("IMAGE",""))
        detailsLink.text = args.getString("URL")
    }
}