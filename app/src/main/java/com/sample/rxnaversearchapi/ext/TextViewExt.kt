package com.sample.rxnaversearchapi.ext

import android.text.Html
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("bind:convertHtml")
fun TextView.convertHtml(text: String?) {
    text?.let {
        this.text = Html.fromHtml(it, Html.FROM_HTML_MODE_LEGACY)
    }
}
