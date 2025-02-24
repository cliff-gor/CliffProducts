package com.cliffgor.pezeshaproducts.data.repository

import com.cliffgor.pezeshaproducts.data.local.ProductDao
import com.cliffgor.pezeshaproducts.data.model.Product
import com.cliffgor.pezeshaproducts.data.remote.ApiService
import com.cliffgor.pezeshaproducts.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val apiService: ApiService,
    private val productDao: ProductDao
) {
    fun getProducts(): Flow<Resource<List<Product>>> = flow {
        emit(Resource.Loading())
        try {
            val products = apiService.getProducts()
            productDao.insertProducts(products)
            productDao.getProducts().collect { cachedProducts ->
                emit(Resource.Success(cachedProducts))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "An unknown error occurred"))
        }
    }

    suspend fun getProductById(id: Int): Product {
        return productDao.getProductById(id)
    }
}