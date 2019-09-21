package com.gmail.davorlukic82.news.ui.fragments

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.gmail.davorlukic82.news.R
import com.gmail.davorlukic82.news.model.Article
import com.gmail.davorlukic82.news.model.NewsFragmentModel
import com.gmail.davorlukic82.news.networking.BackendFactory
import com.gmail.davorlukic82.news.persistance.ArticlesRepository
import com.gmail.davorlukic82.news.presentation.NewsFragmentPresenter
import com.gmail.davorlukic82.news.ui.activities.ArticlesDetailsActivity
import com.gmail.davorlukic82.news.ui.adapters.NewsAdapter
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.fragment_news.*

import kotlin.collections.ArrayList

class NewsFragment : BaseFragment(),
    NewsFragmentContract.View {

    private val adapter by lazy {
        NewsAdapter {
            onItemSelected(it)
        }
    }
    private lateinit var progressDialog: AlertDialog
    private lateinit var alertDialog: AlertDialog
    private lateinit var presenter: NewsFragmentContract.Presenter

    override fun getLayoutResourceId() = R.layout.fragment_news

    companion object {
        fun newInstance(): Fragment {
            return NewsFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
        presenter = NewsFragmentPresenter(
            this,
            NewsFragmentModel(ArticlesRepository(),
                BackendFactory.getArticleInteractor())
        )
        presenter.loadNews()
    }

    private fun initUi() {
        tasksRecyclerView.layoutManager = LinearLayoutManager(context)
        tasksRecyclerView.adapter = adapter
        progressDialog = SpotsDialog(context)
        alertDialog = AlertDialog.Builder(context).setTitle(getString(R.string.alert_title))
            .setMessage(getString(R.string.alert_message))
            .setPositiveButton(getString(R.string.alert_positiveButton), null).create()
    }

    override fun onNewsLoaded(news: ArrayList<Article>) {
        adapter.setData(news)
    }

    override fun showProgress() {
        progressDialog.show()
    }

    override fun hideProgress() {
        progressDialog.dismiss()
    }

    override fun onResponseFailure(throwable: Throwable) {
        alertDialog.show()
    }

    private fun onItemSelected(position: Int) {
        val intent = Intent(context, ArticlesDetailsActivity::class.java).apply {
            putExtra("POSITION", position)
        }
        startActivity(intent)
    }
}
