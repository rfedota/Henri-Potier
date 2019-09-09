package com.xebia.hpotier.ui.books

import android.content.Context
import android.os.Handler
import android.util.Log
import android.widget.Toast
import com.xebia.hpotier.R
import com.xebia.hpotier.core.BaseViewModel
import com.xebia.hpotier.data.remote.api.HpotierApi
import com.xebia.hpotier.data.remote.domain.Book
import com.xebia.hpotier.data.room.dao.CartBookDao
import com.xebia.hpotier.data.room.entity.CartBooks
import com.xebia.hpotier.extension.with
import com.xebia.hpotier.util.NotNullMutableLiveData
import com.xebia.hpotier.util.ioThread

class BookesViewModel(private val context : Context, private val api: HpotierApi, private val dao: CartBookDao) : BaseViewModel() {

    private val _items: NotNullMutableLiveData<ArrayList<Book>> = NotNullMutableLiveData(arrayListOf())
    val items: NotNullMutableLiveData<ArrayList<Book>>
        get() = _items

    private val _shiowShimmer = NotNullMutableLiveData(true)
    val shiowShimmer : NotNullMutableLiveData<Boolean>
        get() = _shiowShimmer

    fun getBooks() {
        addToDisposable(api.getBooks().with()
            .doOnSubscribe { _shiowShimmer.value = true }
            .doOnSuccess { _shiowShimmer.value = false }
            .doOnError { _shiowShimmer.value = false}
            .subscribe({
                _items.value = it
            }, {
                Log.e(context.getString(R.string.ErrorTag), it.message)
            }))
    }

    fun saveToCart(book : Book) {
        Toast.makeText(context, context.getString(R.string.ajouter_au_panier), Toast.LENGTH_LONG).show()
        ioThread { dao.insert(CartBooks.to(book)) }
    }

    init {
        // Example Shimmer
        val handler = Handler()
        handler.postDelayed({
            getBooks()
        }, 1000)

    }

}