package com.empedocles.marsestate.util

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.empedocles.marsestate.R

// Helper function to download image
fun ImageView.downloadFromUrl(url :String ){
    Glide.with(context)
        .load(url)
        .into(this)
}

