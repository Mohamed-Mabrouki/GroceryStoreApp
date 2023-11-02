package com.example.grocerystoreapp.ui.add_product

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.grocerystoreapp.data.Product
import com.example.grocerystoreapp.data.ProductRepository
import com.example.grocerystoreapp.utils.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddProductViewModel @Inject constructor(
	private val repository : ProductRepository,
	savedStateHandle : SavedStateHandle
):ViewModel() {

	var product by mutableStateOf<Product?>(null)
		private set

	var productName by mutableStateOf("")
		private set

	var quantity by  mutableStateOf("")
		private set
	var price by mutableStateOf("")
		private set

	private val _uiEvent = Channel<UiEvent>()
	val uiEvent = _uiEvent.receiveAsFlow()

	init {
		val productId =savedStateHandle.get<Int>("productId")
		Log.d("the id is","$productId")
		if (productId != -1) {
			viewModelScope.launch {
				if (productId != null) {
					repository.getProductById(productId)?.let { product ->
						productName=product.name
						price=product.price
						quantity=product.quantity
						this@AddProductViewModel.product=product
					}
				}
			}
		}

	}
	fun onEvent(event:AddProductEvent){
		when(event){
			is AddProductEvent.OnNameChange     ->{
				productName=event.productName
			}
			is AddProductEvent.OnPriceChange    -> {
				price=event.price
			}
			is AddProductEvent.OnQuantityChange ->{
				quantity=event.quantity
			}
			is AddProductEvent.OnSaveProductClick  ->{
				viewModelScope.launch {
					repository.addProduct(
						Product(
							name = productName,
							price = price,
							quantity = quantity,
							id = product?.id

						)
					)

				}
			}
		}
	}


	private fun sendUiEvent(event : UiEvent) {
		viewModelScope.launch {
			_uiEvent.send(event)
		}
	}
}
