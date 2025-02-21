package com.cliffgor.pezeshaproducts.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.cliffgor.pezeshaproducts.ui.ProductViewModel

@Composable
fun ProductDetailScreen(navController: NavController, productId: Int, viewModel: ProductViewModel = hiltViewModel()) {
    val product = viewModel.getProductById(productId)
    product?.let {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = rememberImagePainter(product.thumbnail),
                contentDescription = product.title,
                modifier = Modifier.fillMaxWidth().height(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = product.title, style = MaterialTheme.typography.h4)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = product.description, style = MaterialTheme.typography.body1)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "$${product.price}", style = MaterialTheme.typography.h5)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { /* Handle Buy Now */ }) {
                Text("Buy Now")
            }
        }
    } ?: run {
        Text("Product not found")
    }
}