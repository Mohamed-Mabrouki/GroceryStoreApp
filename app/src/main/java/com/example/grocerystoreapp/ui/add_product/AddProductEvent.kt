package com.example.grocerystoreapp.ui.add_product

import androidx.compose.foundation.layout.PaddingValues

sealed class AddProductEvent {
	data class OnNameChange(val productName:String):AddProductEvent()
	data class OnPriceChange(val price : String): AddProductEvent()
	data class OnQuantityChange(val quantity:String):AddProductEvent()

	object OnSaveProductClick:AddProductEvent()

}