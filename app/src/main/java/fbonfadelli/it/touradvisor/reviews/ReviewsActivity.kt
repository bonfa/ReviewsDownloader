package fbonfadelli.it.touradvisor.reviews

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import fbonfadelli.it.touradvisor.R
import fbonfadelli.it.touradvisor.reviews.provider.*
import kotlinx.android.synthetic.main.activity_reviews.*

class ReviewsActivity : AppCompatActivity(), ReviewsView {
    private val LOG: String = "ReviewsActivity"

    private lateinit var reviewsPresenter: ReviewsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reviews)
        setTitle(R.string.reviews)
        initPresenter()
        bindView()
    }

    private fun initPresenter() {
        reviewsPresenter = ReviewsPresenter(
                this,
                ReviewRetriever(
                        RetrofitReviewsProvider(
                                RetrofitReviewsServiceFactory().create()
                        ),
                        NetworkReviewsAdapterImpl()
                )
        )
    }

    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var emptyView: LinearLayout
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ReviewsAdapter

    private fun bindView() {
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout)
        recyclerView = findViewById(R.id.recyclerView)
        emptyView = findViewById(R.id.emptyView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ReviewsAdapter(this)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun onResume() {
        super.onResume()
        reviewsPresenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        reviewsPresenter.onPause()
    }

    override fun showLoading() {
        swipeRefreshLayout.isEnabled = true
        swipeRefreshLayout.isRefreshing = true
    }

    override fun hideLoading() {
        swipeRefreshLayout.isRefreshing = false
        swipeRefreshLayout.isEnabled = false
    }

    override fun showReviews(reviews: Reviews) {
        emptyView.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE
        adapter.setReviews(reviews)
    }

    override fun showNoReviews() {
        emptyView.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
    }
}
