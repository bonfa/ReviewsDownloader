package fbonfadelli.it.touradvisor.reviews

import fbonfadelli.it.touradvisor.reviews.provider.ReviewProvider
import fbonfadelli.it.touradvisor.reviews.provider.ReviewProvider.*
import fbonfadelli.it.touradvisor.reviews.provider.ReviewProvider.Strategy.*
import fbonfadelli.it.touradvisor.util.aReview
import org.junit.Test
import org.mockito.Mockito.*

class ReviewsPresenterTest {

    private val reviewsView: ReviewsView = mock(ReviewsView::class.java)
    private val reviewProvider = mock(ReviewProvider::class.java)

    private val reviewsPresenter = ReviewsPresenter(reviewsView, reviewProvider)

    @Test
    fun askForTheReviewsOnResume() {
        reviewsPresenter.onResume()

        verify(reviewsView).showLoading()
        verify(reviewProvider).getReviews(RATING_STRATEGY_DESC, reviewsPresenter)
    }

    @Test
    fun showTheReviews() {
        val reviews = aReview()

        reviewsPresenter.onReviews(reviews)

        verify(reviewsView).showReviews(reviews)
        verify(reviewsView).hideLoading()
        verify(reviewsView).showStrategy(RATING_STRATEGY_DESC)
    }

    @Test
    fun showNoReviews() {
        reviewsPresenter.oNoReviews()

        verify(reviewsView).showNoReviews()
        verify(reviewsView).hideLoading()
    }

    @Test
    fun blockProviderOnPause() {
        reviewsPresenter.onPause()

        verify(reviewsView).hideLoading()
        verify(reviewProvider).stop()
    }

    @Test
    fun toggleRatingStrategy() {
        reviewsPresenter.toogleRatingSearch()

        verify(reviewsView).showLoading()
        verify(reviewProvider).getReviews(RATING_STRATEGY_ASC, reviewsPresenter)

        reviewsPresenter.toogleRatingSearch()

        verify(reviewsView, times(2)).showLoading()
        verify(reviewProvider).getReviews(RATING_STRATEGY_DESC, reviewsPresenter)
    }

}