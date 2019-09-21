package com.gmail.davorlukic82.news.ui.activities

import androidx.viewpager.widget.ViewPager
import com.gmail.davorlukic82.news.R
import com.gmail.davorlukic82.news.model.Article
import com.gmail.davorlukic82.news.model.ArticlesDetailsActivityModel
import com.gmail.davorlukic82.news.persistance.ArticlesRepository
import com.gmail.davorlukic82.news.presentation.ArticlesDetailsActivityPresenter
import com.gmail.davorlukic82.news.ui.adapters.ArticlesPagerAdapter

class ArticlesDetailsActivity : BaseActivity(), ArticlesDetailsActivityContract.View {

    private lateinit var viewPager: ViewPager
    private lateinit var presenter: ArticlesDetailsActivityContract.Presenter
    private lateinit var  pagerAdapter: ArticlesPagerAdapter

    override fun getLayoutResourceId() = R.layout.activity_articles_details

    override fun setUpUi() {
        viewPager = findViewById(R.id.viewPager)

        presenter = ArticlesDetailsActivityPresenter(
            this,
            ArticlesDetailsActivityModel(ArticlesRepository())
        )

        presenter.requestArticles()
        presenter.requestActionBar(intent.getIntExtra("POSITION", 0))

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                presenter.requestTitle(position)
            }
        })
    }

    override fun setDataToViewPager(articles: ArrayList<Article>) {
        pagerAdapter = ArticlesPagerAdapter(supportFragmentManager, articles)
        viewPager.adapter = pagerAdapter
        viewPager.currentItem = intent.getIntExtra("POSITION", 0)
    }

    override fun setActionBar(title: String?) {
        supportActionBar!!.title = title
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_arrow)
    }

    override fun onRequestTitle(title: String?) {
        supportActionBar!!.title = title
    }
}
