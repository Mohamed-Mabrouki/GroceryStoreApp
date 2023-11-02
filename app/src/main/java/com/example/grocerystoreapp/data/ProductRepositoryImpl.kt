package com.example.grocerystoreapp.data

import kotlinx.coroutines.flow.Flow

class ProductRepositoryImpl(private val dao : ProductDao): ProductRepository {
	override suspend fun addProduct(product : Product) {
		dao.addProduct(product)
	}

	override suspend fun deleteProduct(product : Product) {
		dao.deleteProduct(product)
	}

	override suspend fun getProductById(id : Int) : Product? {
		return dao.getProductById(id)
	}

	override fun getAllProducts() : Flow<List<Product>> {
		return dao.getAllProducts()
	}


}