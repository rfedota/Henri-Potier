package com.xebia.hpotier.ui.books

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.annotation.LayoutRes
import androidx.lifecycle.Observer
import com.xebia.hpotier.R
import com.xebia.hpotier.databinding.ActivityBooksBinding
import com.xebia.hpotier.ui.BindingActivity
import com.xebia.hpotier.ui.cart.CartActivity
import kotlinx.android.synthetic.main.activity_books.*
import org.koin.androidx.viewmodel.ext.android.getViewModel

class BooksActivity : BindingActivity<ActivityBooksBinding>() {

    lateinit var vm : BookesViewModel

    @LayoutRes
    override fun getLayoutResId() = R.layout.activity_books

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = getViewModel()
        binding.vm = getViewModel()
        binding.setLifecycleOwner(this)

        vm.shiowShimmer.observe(this, Observer { animation ->
            shimmerAnimation(animation)
        })

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_list_books, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.go_to_cart -> {
                startActivity(Intent(this, CartActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun shimmerAnimation(animation : Boolean){
        if(animation) {
            shimmer_layout.visibility = LinearLayout.VISIBLE
            shimmer_layout.startShimmer()
        } else {
            shimmer_layout.visibility = LinearLayout.GONE
            shimmer_layout.stopShimmer()
        }
    }
}
