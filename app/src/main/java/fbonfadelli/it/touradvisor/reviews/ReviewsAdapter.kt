package fbonfadelli.it.touradvisor.reviews

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import fbonfadelli.it.touradvisor.R
import fbonfadelli.it.touradvisor.reviews.provider.Review
import fbonfadelli.it.touradvisor.reviews.provider.Reviews

class ReviewsAdapter : RecyclerView.Adapter<ReviewViewHolder>() {

    private val reviews: MutableList<Review> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_review, parent, false)
        return ReviewViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return reviews.size
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        val review = reviews.get(position)

        holder.titleTextView.text = review.title
        holder.messageTextView.text = review.message
        holder.dateTextView.text = review.date
        holder.userNameTextView.text = review.reviewerName
        holder.countryTextView.text = review.reviewerCountry
        holder.ratingTextView.text = review.rating
        holder.typeTextView.text = review.travelerType
    }

    fun setReviews(reviews: Reviews) {
        this.reviews.clear()
        this.reviews.addAll(reviews.reviews)
        notifyDataSetChanged()
    }
}

class ReviewViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val titleTextView: TextView = view.findViewById(R.id.titleTextView)
    val typeTextView: TextView = view.findViewById(R.id.typeTextView)
    val messageTextView: TextView = view.findViewById(R.id.messageTextView)
    val dateTextView: TextView = view.findViewById(R.id.dateTextView)
    val userNameTextView: TextView = view.findViewById(R.id.userNameTextView)
    val countryTextView: TextView = view.findViewById(R.id.countryTextView)
    val ratingTextView: TextView = view.findViewById(R.id.ratingTextView)
}
