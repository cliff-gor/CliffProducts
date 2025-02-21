package com.cliffgor.pezeshaproducts.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cliffgor.pezeshaproducts.data.model.Product

@Database(entities = [Product::class], version = 1)
abstract class ProductDatabase: RoomDatabase() {
    abstract fun productDao(): ProductDao
}