package com.xebia.hpotier.ui.cart

import android.content.Context
import android.util.Log
import com.xebia.hpotier.R
import com.xebia.hpotier.core.BaseViewModel
import com.xebia.hpotier.data.remote.api.HpotierApi
import com.xebia.hpotier.data.remote.domain.CommercialOffers
import com.xebia.hpotier.data.room.dao.CartBookDao
import com.xebia.hpotier.data.room.entity.CartBooks
import com.xebia.hpotier.extension.with
import com.xebia.hpotier.util.CalculesUtils
import com.xebia.hpotier.util.NotNullMutableLiveData
import com.xebia.hpotier.util.ioThread

class CartViewModel(
    private val context: Context,
    private val dao: CartBookDao,
    private val api: HpotierApi
) : BaseViewModel() {

    private val _totalePrice: NotNullMutableLiveData<Int> = NotNullMutableLiveData(0)
    val totalPrice: NotNullMutableLiveData<Int>
        get() = _totalePrice

    private val _discount: NotNullMutableLiveData<Int> = NotNullMutableLiveData(0)
    val discount: NotNullMutableLiveData<Int>
        get() = _discount

    private val _totalPriceDiscount: NotNullMutableLiveData<Int> = NotNullMutableLiveData(0)
    val totalPriceDiscount: NotNullMutableLiveData<Int>
        get() = _totalPriceDiscount

    private val _items: NotNullMutableLiveData<List<CartBooks>> = NotNullMutableLiveData(arrayListOf())
    val items: NotNullMutableLiveData<List<CartBooks>>
        get() = _items

    private val _isListItemEmpry: NotNullMutableLiveData<Boolean> = NotNullMutableLiveData(true)
    val isListItemEmpry: NotNullMutableLiveData<Boolean>
        get() = _isListItemEmpry

    var _itemsIsbn: List<String> = arrayListOf()

    lateinit var listQueryParams: String

    lateinit var offre: CommercialOffers

    fun getIsbnCode() {
        addToDisposable(dao.findAllIsbnCode().with().subscribe({
            _itemsIsbn = it
            showHideContainer()
        }, {
            Log.e(context.getString(R.string.ErrorTag), it.message)
        }))
    }

    fun showHideContainer() {
        if (_itemsIsbn.isEmpty()) {
            _isListItemEmpry.value = true
        } else {
            _isListItemEmpry.value = false
            getParameterCall()
        }
    }

    fun getParameterCall() {
        kotlin.run {
            listQueryParams = getQueryParameter()
            getCommercialOffers()
        }
    }

    fun getCommercialOffers() {
        addToDisposable(
            api.commercialOffers(listQueryParams).with().subscribe({
                offre = it
                getCartBook()
            }, {
                Log.e(context.getString(R.string.ErrorTag), it.message)
            })
        )
    }

    fun getCartBook() {
        addToDisposable(dao.findAll().with()
            .subscribe({
                _items.value = it
                getMaxOffre()
            }, {
                Log.e(context.getString(R.string.ErrorTag), it.message)
            })
        )
    }

    fun getMaxOffre() {
        kotlin.run {
            _totalePrice.value = CalculesUtils.calculeTotal(_items.value)
            _discount.value = CalculesUtils.calculateMaxOffre(_totalePrice.value, offre.offers)
            _totalPriceDiscount.value = CalculesUtils.calculeTotalDiscount(_totalePrice.value, _discount.value)
        }
    }

    fun deleteToCart(book: CartBooks) {
        ioThread {
            dao.delete(book)
            getIsbnCode()
        }
    }

    fun getQueryParameter(): String {
        var tempString = ""
        for (itemis in _itemsIsbn) tempString += "," + itemis
        return tempString
    }

    init {
        getIsbnCode()
    }
}