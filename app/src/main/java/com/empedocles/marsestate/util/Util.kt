package com.empedocles.marsestate.util

import android.content.Context
import android.os.Build
import android.text.Html
import android.text.Spanned
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.empedocles.marsestate.R

// Helper function to download image
fun ImageView.downloadFromUrl(url :String){
    Glide.with(context)
        .load(url)
        .into(this)
}

fun String.fromHtml(): Spanned {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
        Html.fromHtml(this, Html.FROM_HTML_MODE_COMPACT)
    }else{
        Html.fromHtml(this)
    }
}
