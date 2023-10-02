package com.example.imdb2.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.imdb2.R
import com.example.imdb2.SearchFragment
import com.example.imdb2.core.Constant
import com.example.imdb2.models.MovieModel

class AdapterMovie(
    val context: SearchFragment,
    var listMovies: List<MovieModel>
): RecyclerView.Adapter<AdapterMovie.ViewHolder>() {

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val cvMovie = itemView.findViewById(R.id.cv_movie) as CardView
        val ivPoster = itemView.findViewById(R.id.iv_poster) as ImageView


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_movies,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = listMovies[position]

        Glide
            .with(context)
            .load("${Constant.BASE_URL_IMAGES}${movie.poster}")
            .apply { RequestOptions().override(Constant.IMAGE_WIDTH,Constant.IMAGE_HEIGHT)}
            .into(holder.ivPoster)

    }

    override fun getItemCount(): Int {
        return listMovies.size
    }
}