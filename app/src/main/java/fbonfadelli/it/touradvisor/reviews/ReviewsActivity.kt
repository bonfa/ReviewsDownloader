package fbonfadelli.it.touradvisor.reviews

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import fbonfadelli.it.touradvisor.R
import fbonfadelli.it.touradvisor.reviews.provider.*

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

    override fun onResume() {
        super.onResume()
        reviewsPresenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        reviewsPresenter.onPause()
    }

    private fun bindView() {
        //todo
    }

    override fun showLoading() {
        Log.w(LOG, "Show Loading")
    }

    override fun hideLoading() {
        Log.w(LOG, "Hide Loading")
    }

    override fun showReviews(reviews: Reviews) {
        Log.w(LOG, "Show Reviews: " + reviews.toString())
    }

    override fun showNoReviews() {
        Log.w(LOG, "No Reviews available")
    }
}
