package com.xebia.hpotier.ui.cart

import android.os.Bundle
import androidx.annotation.LayoutRes
import com.xebia.hpotier.R
import com.xebia.hpotier.databinding.ActivityCartBinding
import com.xebia.hpotier.ui.BindingActivity
import org.koin.androidx.viewmodel.ext.android.getViewModel

class CartActivity : BindingActivity<ActivityCartBinding>() {
    lateinit var mv : CartViewModel

    @LayoutRes
    override fun getLayoutResId() = R.layout.activity_cart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mv = getViewModel()
        binding.vm = getViewModel()
        binding.setLifecycleOwner(this)
    }
}
