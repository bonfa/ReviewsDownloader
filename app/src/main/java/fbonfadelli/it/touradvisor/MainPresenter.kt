package fbonfadelli.it.touradvisor

class MainPresenter(private val mainView: MainView) {
    fun onShowReviews() {
        mainView.showReviews()
    }
}
