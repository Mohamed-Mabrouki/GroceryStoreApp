package com.example.grocerystoreapp.ui.add_product

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.grocerystoreapp.utils.UiEvent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AddProductScreen(
	viewModel : AddProductViewModel = hiltViewModel(),
	onPopBackStack:()->Unit
) {
	val scaffoldState = rememberScaffoldState()
	LaunchedEffect(key1 = true) {
		viewModel.uiEvent.collect { event ->
			when (event) {
				is UiEvent.PopBackStack -> TODO()
				is UiEvent.ShowSnackBar -> TODO()
				else                    -> Unit
			}
		}
	}
	Scaffold(scaffoldState = scaffoldState,
		modifier = Modifier
			.fillMaxSize()
			.padding(16.dp),
		floatingActionButton = {
			FloatingActionButton(onClick = {
				viewModel.onEvent(AddProductEvent.OnSaveProductClick)
				onPopBackStack()

			}) {
				Icon(imageVector = Icons.Default.Check, contentDescription = "ADD")
			}
		}) {
		Column(modifier = Modifier.fillMaxSize()) {
			TextField(value = viewModel.productName,
				onValueChange = { viewModel.onEvent(AddProductEvent.OnNameChange(it)) },
				placeholder = {
					Text(text = "product name")
				})
			Spacer(modifier = Modifier.height(10.dp))
			TextField(value = viewModel.price, onValueChange = {
				viewModel.onEvent(AddProductEvent.OnPriceChange(it))
			}, placeholder = {
				Text(text = "price")
			})

			Spacer(modifier = Modifier.height(10.dp))

			TextField(value = viewModel.quantity, onValueChange = {
				viewModel.onEvent(AddProductEvent.OnQuantityChange(it))
			}, placeholder = {
				Text(text = "quantity")
			})

			Spacer(modifier = Modifier.height(10.dp))
		}
	}

}