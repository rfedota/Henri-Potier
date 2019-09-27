package com.xebia.hpotier.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.xebia.hpotier.data.remote.domain.Book

@Entity(tableName = "CartBooks")
data class CartBooks(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "isbn") val isbn: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "price") val price: Int,
    @ColumnInfo(name = "cover") val cover: String
) {
    companion object {
        fun to(book: Book): CartBooks {
            return CartBooks(
                isbn = book.isbn,
                title = book.title,
                price = book.price,
                cover = book.cover
            )
        }
    }
}