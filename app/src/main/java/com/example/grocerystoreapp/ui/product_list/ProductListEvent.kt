package com.example.grocerystoreapp.ui.product_list

import com.example.grocerystoreapp.data.Product

sealed class ProductListEvent {
	data class OnDeleteProduct(val product : Product) : ProductListEvent()

	data class OnUndoDeleteClick(val product : Product) : ProductListEvent()

	object OnAddProductClick : ProductListEvent()
	data class OnProductClick(val product : Product ) : ProductListEvent()



}