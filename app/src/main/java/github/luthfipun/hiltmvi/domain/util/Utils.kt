package github.luthfipun.hiltmvi.domain.util

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar

fun ImageView.loadImage(url: String) {
    Glide.with(this)
        .load(url)
        .into(this)
}

fun View.alert(string: String?) {
    Snackbar.make(this, string ?: "Unknown Error", Snackbar.LENGTH_LONG).show()
}