package com.example.grocerystoreapp.ui.product_list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.grocerystoreapp.data.ProductRepository
import com.example.grocerystoreapp.utils.Routes
import com.example.grocerystoreapp.utils.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
	private val repository : ProductRepository
) : ViewModel() {
	val products = repository.getAllProducts()
	private val _uiEvent = Channel<UiEvent>()
	val uiEvent = _uiEvent.receiveAsFlow()

	fun onEvent(event : ProductListEvent) {
		when (event) {
			is ProductListEvent.OnAddProductClick -> {
				sendUiEvent(UiEvent.Navigate(Routes.ADD_PRODUCT))
			}

			is ProductListEvent.OnDeleteProduct   -> {
				viewModelScope.launch {
					repository.deleteProduct(product = event.product)
				}

			}

			is ProductListEvent.OnUndoDeleteClick -> Unit
			is ProductListEvent.OnProductClick    -> {
				sendUiEvent(UiEvent.Navigate(Routes.ADD_PRODUCT + "?productId=${event.product.id}"))


			}
		}


	}

	private fun sendUiEvent(event : UiEvent) {
		viewModelScope.launch {
			_uiEvent.send(event)
		}
	}

}