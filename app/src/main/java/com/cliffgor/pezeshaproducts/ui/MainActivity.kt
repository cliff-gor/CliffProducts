package com.cliffgor.pezeshaproducts.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cliffgor.pezeshaproducts.ui.theme.PezeshaProductsTheme
import com.cliffgor.pezeshaproducts.ui.view.ProductDetailScreen
import com.cliffgor.pezeshaproducts.ui.view.ProductListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PezeshaProductsTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "product_list") {
                        composable("product_list") { ProductListScreen(navController) }
                        composable("product_detail/{productId}") { backStackEntry ->
                            val productId = backStackEntry.arguments?.getString("productId")?.toInt() ?: 0
                            ProductDetailScreen(navController, productId)
                        }
                    }
                }
            }
        }
    }
}