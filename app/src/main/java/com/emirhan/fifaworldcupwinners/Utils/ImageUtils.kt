package com.h5210060_emirhan.ustun_final

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.internettenCek(url:String){
    Glide.with(context)
        .load(url)
        .error(R.drawable.trash)
        .fitCenter()
        .into(this)
}