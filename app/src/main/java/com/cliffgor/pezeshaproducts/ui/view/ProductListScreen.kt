package com.cliffgor.pezeshaproducts.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.cliffgor.pezeshaproducts.ui.ProductViewModel
import com.cliffgor.pezeshaproducts.util.Resource

@Composable
fun ProductListScreen(navController: NavController, viewModel: ProductViewModel = hiltViewModel()) {
    val products by viewModel.products.collectAsState()
    var searchQuery by remember { mutableStateOf("") }

    Column {
        SearchBar(
            query = searchQuery,
            onQueryChanged = { searchQuery = it }
        )
        when (products) {
            is Resource.Loading -> CircularProgressIndicator()
            is Resource.Success -> {
                val filteredProducts = products.data!!.filter {
                    it.title.contains(searchQuery, ignoreCase = true)
                }
                LazyColumn {
                    items(filteredProducts) { product ->
                        ProductItem(product) {
                            navController.navigate("product_detail/${product.id}")
                        }
                    }
                }
            }
            is Resource.Error -> Text(text = "Error: ${products.message}")
        }
    }
}