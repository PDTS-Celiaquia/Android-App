package ar.edu.mdp.fi.celiaquia

import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.databinding.BindingAdapter

@BindingAdapter("android:html")
fun TextView.setHtml(html: String?) {
    html?.let {
        text = HtmlCompat.fromHtml(it, HtmlCompat.FROM_HTML_MODE_COMPACT)
    }
}

@BindingAdapter("android:src")
fun ImageView.setResource(resource: Int) {
    setImageResource(resource)
}