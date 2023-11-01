package com.example.grocerystoreapp.data

import kotlinx.coroutines.flow.Flow

class ProductRepositoryImpl(private val dao : ProductDao): ProductRepository {
	override suspend fun addProduct(product : Product) {
		dao.addProduct(product)
	}

	override suspend fun deleteProduct(product : Product) {
		dao.deleteProduct(product)
	}

	override fun getAllProducts() : Flow<List<Product>> {
		return dao.getAllProducts()
	}


}