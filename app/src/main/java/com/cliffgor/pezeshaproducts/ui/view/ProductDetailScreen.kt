package com.cliffgor.pezeshaproducts.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.cliffgor.pezeshaproducts.ui.ProductViewModel

@Composable
fun ProductDetailScreen(navController: NavController, productId: Int, viewModel: ProductViewModel = hiltViewModel()) {
    val product by remember { mutableStateOf(viewModel.getProductById(productId)) }

    product?.let {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = rememberAsyncImagePainter(it.thumbnail),
                contentDescription = it.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = it.title, style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = it.description, style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "$${it.price}", style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { /* Handle Buy Now */ }) {
                Text("Buy Now")
            }
        }
    } ?: run {
        Text("Product not found")
    }
}