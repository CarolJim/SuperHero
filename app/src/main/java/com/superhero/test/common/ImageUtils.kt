package com.superhero.test.common

import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import test.R

fun ImageView.setImage(image: String) {
    Glide.with(this.context).load(image)
        .error(ContextCompat.getDrawable(this.context, R.drawable.ic_launcher_background))
        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
        .dontAnimate()
        .into(this)
}

fun resizeImageUrl(image: String): String = "$image?iresize=width:200,height:140"

