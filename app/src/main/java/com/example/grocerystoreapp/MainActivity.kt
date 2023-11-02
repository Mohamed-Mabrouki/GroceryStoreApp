package com.example.grocerystoreapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.grocerystoreapp.ui.add_product.AddProductScreen
import com.example.grocerystoreapp.ui.product_list.product_list_screen.ProductListScreen
import com.example.grocerystoreapp.ui.theme.GroceryStoreAppTheme
import com.example.grocerystoreapp.utils.Routes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState : Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			GroceryStoreAppTheme { // A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
				) {
					val navController = rememberNavController()
					NavHost(
						navController = navController, startDestination = Routes.PRODUCT_LIST
					) {
						composable(Routes.PRODUCT_LIST) {
							ProductListScreen(onNavigate = {
								navController.navigate(it.route)
							})
						}
						composable(route = Routes.ADD_PRODUCT+ "?productId={productId}",
							arguments = listOf(navArgument(name = "productId") {
								type = NavType.IntType
								defaultValue = -1
							})
							) {
							AddProductScreen(onPopBackStack = { navController.popBackStack() })
						}
					}
				}
			}
		}
	}
}

