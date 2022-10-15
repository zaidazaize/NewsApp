package com.example.newsapp.home

import android.widget.ImageView
import android.widget.Toast
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.newsapp.R

@BindingAdapter("imageUrl")
fun bindImage(image: ImageView, imageUrl: String?) {
    Toast.makeText(image.context,"loading",Toast.LENGTH_SHORT).show()
    imageUrl?.let {
        val imageUri = imageUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(image.context)
            .load(imageUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image)
            )
            .into(image)
    }
}