package fbonfadelli.it.touradvisor.main

class MainPresenter(private val mainView: MainView) {
    fun onShowReviews() {
        mainView.showReviews()
    }
}
