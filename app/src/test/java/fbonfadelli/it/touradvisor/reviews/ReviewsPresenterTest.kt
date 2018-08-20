package fbonfadelli.it.touradvisor.reviews

import fbonfadelli.it.touradvisor.reviews.provider.ReviewProvider
import fbonfadelli.it.touradvisor.reviews.provider.Reviews
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class ReviewsPresenterTest {

    private val reviewsView: ReviewsView = mock(ReviewsView::class.java)
    private val reviewProvider = mock(ReviewProvider::class.java)

    private val reviewsPresenter = ReviewsPresenter(reviewsView, reviewProvider)

    @Test
    fun askForTheReviews() {
        reviewsPresenter.onResume()

        verify(reviewsView).showLoading()
        verify(reviewProvider).getReviews()
    }

    @Test
    fun showTheReviews() {
        val reviews = Reviews()

        reviewsPresenter.onReviews(reviews)

        verify(reviewsView).showReviews(reviews)
        verify(reviewsView).hideLoading()
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
}