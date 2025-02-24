package com.cliffgor.pezeshaproducts.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cliffgor.pezeshaproducts.data.model.Product
import com.cliffgor.pezeshaproducts.data.repository.ProductRepository
import com.cliffgor.pezeshaproducts.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val repository: ProductRepository
) : ViewModel() {
    private val _products = MutableStateFlow<Resource<List<Product>>>(Resource.Loading())
    val products: StateFlow<Resource<List<Product>>> = _products

    init {
        fetchProducts()
    }

    private fun fetchProducts() {
        viewModelScope.launch {
            repository.getProducts().collect {
                _products.value = it
            }
        }
    }

    fun getProductById(id: Int): Product? {
        return _products.value.data?.find { it.id == id }
    }
}