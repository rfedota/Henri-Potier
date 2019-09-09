package com.xebia.hpotier.ui.books

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xebia.hpotier.R
import com.xebia.hpotier.data.remote.domain.Book
import com.xebia.hpotier.databinding.ItemBookBinding
import com.xebia.hpotier.ui.BindingViewHolder

class BookAdapter(var items: ArrayList<Book> = arrayListOf(), val vm: BookesViewModel) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        return BookViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_book,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.binding.item = items[position]
        holder.binding.vm = vm
    }

    override fun getItemCount() = items.size

    class BookViewHolder(view: View) : BindingViewHolder<ItemBookBinding>(view)
}