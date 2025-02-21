package com.cliffgor.pezeshaproducts.di

import android.content.Context
import androidx.room.Room
import com.cliffgor.pezeshaproducts.data.local.ProductDatabase
import com.cliffgor.pezeshaproducts.data.remote.ApiService
import com.cliffgor.pezeshaproducts.data.remote.RetrofitInstance
import com.cliffgor.pezeshaproducts.data.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiService(): ApiService = RetrofitInstance.api

    @Provides
    @Singleton
    fun provideProductDatabase(context: Context): ProductDatabase {
        return Room.databaseBuilder(
            context,
            ProductDatabase::class.java,
            "product_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideProductDao(database: ProductDatabase) = database.productDao()

    @Provides
    @Singleton
    fun provideProductRepository(
        apiService: ApiService,
        productDao: ProductDatabase
    ): ProductRepository {
        return ProductRepository(apiService, productDao.productDao())
    }
}