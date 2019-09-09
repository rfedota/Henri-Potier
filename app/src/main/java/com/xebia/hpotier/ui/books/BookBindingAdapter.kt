package com.xebia.hpotier.ui.books

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.xebia.hpotier.data.remote.domain.Book

@BindingAdapter(value = ["book", "viewModel"])
fun setRepositories(view: RecyclerView, items: ArrayList<Book>, vm: BookesViewModel) {
    view.adapter?.run {
        if (this is BookAdapter) {
            this.items = items
            this.notifyDataSetChanged()
        }
    } ?: run {
        BookAdapter(items, vm).apply { view.adapter = this }
    }
}

@BindingAdapter(value = ["imageUrl"])
fun setImageUrl(view: ImageView, url: String) {
    Glide.with(view.getContext()).load(url).into(view)
}