package fbonfadelli.it.touradvisor.reviews

import org.junit.Test
import org.mockito.Mockito

class ReviewsPresenterTest {

    private val reviewsView: ReviewsView = Mockito.mock(ReviewsView::class.java)
    private val reviewProvider = Mockito.mock(ReviewProvider::class.java)

    private val reviewsPresenter = ReviewsPresenter(reviewsView, reviewProvider)

    @Test
    fun askForTheReviews() {
        reviewsPresenter.onResume()

        Mockito.verify(reviewsView).showLoading()
        Mockito.verify(reviewProvider).getReviews()
    }

    @Test
    fun showTheReviews() {
        val reviews = Reviews()

        reviewsPresenter.onReviews(reviews)

        Mockito.verify(reviewsView).showReviews(reviews)
        Mockito.verify(reviewsView).hideLoading()
    }

    @Test
    fun showNoReviews() {
        reviewsPresenter.oNoReviews()

        Mockito.verify(reviewsView).showNoReviews()
        Mockito.verify(reviewsView).hideLoading()
    }
}