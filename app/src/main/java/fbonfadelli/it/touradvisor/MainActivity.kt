package fbonfadelli.it.touradvisor

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initPresenter()
        bindView()
    }

    private fun initPresenter() {
        mainPresenter = MainPresenter(this)
    }

    private fun bindView() {
        val showReviewButton = findViewById<Button>(R.id.showReviewsButton)
        showReviewButton.setOnClickListener { this.mainPresenter.onShowReviews() }
    }

    override fun showReviews() {
        val intent = Intent(this, ReviewsActivity::class.java)
        startActivity(intent)
    }
}
