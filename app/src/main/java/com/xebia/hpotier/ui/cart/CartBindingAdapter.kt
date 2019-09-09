package com.xebia.hpotier.ui.cart

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.xebia.hpotier.data.room.entity.CartBooks

@BindingAdapter(value = ["cart","viewModel"])
fun setRepositories(view: RecyclerView, items: List<CartBooks>, vm: CartViewModel) {
    view.adapter?.run {
        if (this is CartAdapter) {
            this.items = items
            this.notifyDataSetChanged()
        }
    } ?: run {
        CartAdapter(items, vm).apply { view.adapter = this }
    }
}

@BindingAdapter(value = ["image"])
fun setImageUrl(view: ImageView, url: String) {
    Glide.with(view.getContext()).load(url).into(view)
}