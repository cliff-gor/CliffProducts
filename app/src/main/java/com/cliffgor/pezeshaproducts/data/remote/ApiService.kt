package com.cliffgor.pezeshaproducts.data.remote

import com.cliffgor.pezeshaproducts.data.model.Product
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getProducts(): List<Product>
}