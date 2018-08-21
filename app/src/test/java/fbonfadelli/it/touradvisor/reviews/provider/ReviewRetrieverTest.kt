package fbonfadelli.it.touradvisor.reviews.provider

import org.junit.Ignore
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class ReviewRetrieverTest {
    private val networkReviewsProvider = mock(NetworkReviewsProvider::class.java)
    private val networkReviewsAdapter = mock(NetworkReviewsAdapter::class.java)
    private val networkReviewProvider = ReviewRetriever(networkReviewsProvider, networkReviewsAdapter)

    @Test@Ignore
    fun getReviews() {
       //todo
    }

    @Test@Ignore
    fun getNoReviews() {
        //todo
    }

    @Test
    fun stop() {
        networkReviewProvider.stop()

        verify(networkReviewsProvider).stop()
    }
}