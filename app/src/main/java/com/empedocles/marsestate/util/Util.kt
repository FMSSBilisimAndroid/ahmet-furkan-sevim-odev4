package com.empedocles.marsestate.util

import android.widget.ImageView
import com.bumptech.glide.Glide

// Helper function to download image
fun ImageView.downloadFromUrl(url :String){
    Glide.with(context)
        .load(url)
        .into(this)
}