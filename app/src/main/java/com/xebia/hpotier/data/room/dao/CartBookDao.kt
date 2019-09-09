package com.xebia.hpotier.data.room.dao

import androidx.room.*
import com.xebia.hpotier.data.room.entity.CartBooks
import io.reactivex.Single

@Dao
interface CartBookDao {

    @Query("SELECT * FROM CartBooks ORDER BY price ASC")
    fun findAll(): Single<List<CartBooks>>

    @Query("SELECT isbn FROM CartBooks")
    fun findAllIsbnCode(): Single<List<String>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(books: CartBooks)

    @Delete
    fun delete(books: CartBooks)

}