package fbonfadelli.it.touradvisor

import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class MainActivityPresenterTest {

    @Test
    fun showsTheReviews() {
        val mainView: MainView = mock(MainView::class.java)
        val mainPresenter = MainPresenter(mainView)

        mainPresenter.onShowReviews()

        verify(mainView).showReviews()
    }
}