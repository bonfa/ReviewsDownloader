package fbonfadelli.it.touradvisor.reviews.provider

data class Review(
        val id: Long,
        val rating: Double,
        val title: String,
        val message: String,
        val author: String,
        val foreignLanguage: Boolean,
        val date: String,
        val languageCode: String,
        val travelerType: String,
        val reviewerName: String,
        val reviewerCountry: String
)