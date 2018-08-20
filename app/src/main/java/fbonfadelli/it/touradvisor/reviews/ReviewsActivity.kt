package fbonfadelli.it.touradvisor.reviews

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import fbonfadelli.it.touradvisor.R

class ReviewsActivity : AppCompatActivity(), ReviewsView {

    private lateinit var reviewsPresenter: ReviewsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reviews)
        setTitle(R.string.reviews)
        initPresenter()
        bindView()
    }

    private fun initPresenter() {
        reviewsPresenter = ReviewsPresenter(this)
    }

    private fun bindView() {
        //todo
    }
}
