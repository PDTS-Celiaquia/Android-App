package ar.edu.mdp.fi.celiaquia

import android.widget.ImageView
import androidx.databinding.BindingAdapter

// no funciona nspq
//@BindingAdapter("html")
//fun TextView.setHtml(html: String) {
//    text = HtmlCompat.fromHtml(
//        "<h2>Title</h2><br><p>Description here $html </p>",
//        HtmlCompat.FROM_HTML_MODE_COMPACT
//    )
//}

@BindingAdapter("android:src")
fun ImageView.setResource(resource: Int) {
    setImageResource(resource)
}