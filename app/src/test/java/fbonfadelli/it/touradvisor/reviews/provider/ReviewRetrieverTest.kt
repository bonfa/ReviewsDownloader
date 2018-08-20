package fbonfadelli.it.touradvisor.reviews.provider

import fbonfadelli.it.touradvisor.reviews.ReviewProviderCallback
import fbonfadelli.it.touradvisor.util.emptyReviews
import fbonfadelli.it.touradvisor.util.expectedNetworkReviews
import fbonfadelli.it.touradvisor.util.expectedReviews
import org.junit.Test
import org.mockito.Mockito.*

class ReviewRetrieverTest {
    private val networkReviewsProvider = mock(NetworkReviewsProvider::class.java)
    private val networkReviewsAdapter = mock(NetworkReviewsAdapter::class.java)
    private val networkReviewProvider = ReviewRetriever(networkReviewsProvider, networkReviewsAdapter)

    @Test
    fun getReviews() {
        `when`(networkReviewsProvider.getReviews(1, 5))
                .thenReturn(expectedNetworkReviews())

        `when`(networkReviewsAdapter.adapt(expectedNetworkReviews()))
                .thenReturn(expectedReviews())

        val reviewProviderCallback = mock(ReviewProviderCallback::class.java)
        networkReviewProvider.getReviews(reviewProviderCallback)

        verify(reviewProviderCallback).onReviews(expectedReviews())
    }

    @Test
    fun getNoReviews() {
        `when`(networkReviewsProvider.getReviews(1, 5))
                .thenReturn(expectedNetworkReviews())

        `when`(networkReviewsAdapter.adapt(expectedNetworkReviews()))
                .thenReturn(emptyReviews())

        val reviewProviderCallback = mock(ReviewProviderCallback::class.java)
        networkReviewProvider.getReviews(reviewProviderCallback)

        verify(reviewProviderCallback).oNoReviews()
    }

    @Test
    fun stop() {
        networkReviewProvider.stop()

        verify(networkReviewsProvider).stop()
    }
}