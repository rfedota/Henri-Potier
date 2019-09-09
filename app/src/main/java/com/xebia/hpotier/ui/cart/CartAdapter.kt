package com.xebia.hpotier.ui.cart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xebia.hpotier.R
import com.xebia.hpotier.data.room.entity.CartBooks
import com.xebia.hpotier.databinding.ItemCartBinding
import com.xebia.hpotier.ui.BindingViewHolder

class CartAdapter(var items: List<CartBooks> = listOf(), var vm: CartViewModel) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        return CartViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_cart,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.binding.item = items[position]
        holder.binding.vm = vm
    }

    override fun getItemCount() = items.size

    class CartViewHolder(view: View) : BindingViewHolder<ItemCartBinding>(view)
}