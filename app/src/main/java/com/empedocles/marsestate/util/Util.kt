package com.empedocles.marsestate.util

import android.content.Context
import android.os.Build
import android.text.Html
import android.text.Spanned
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide


// Helper function to download image
fun ImageView.downloadFromUrl(url :String, circularProgressDrawable: CircularProgressDrawable){
    Glide.with(context)
        .load(url)
        .placeholder(circularProgressDrawable)
        .into(this)
}

fun circularProgressFactory(context: Context): CircularProgressDrawable{
    val circularProgressDrawable = CircularProgressDrawable(context)
    circularProgressDrawable.strokeWidth = 5f
    circularProgressDrawable.centerRadius = 30f
    circularProgressDrawable.start()
    return circularProgressDrawable
}

fun String.fromHtml(): Spanned {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
        Html.fromHtml(this, Html.FROM_HTML_MODE_COMPACT)
    }else{
        Html.fromHtml(this)
    }
}
