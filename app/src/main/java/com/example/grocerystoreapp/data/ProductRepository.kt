package com.example.grocerystoreapp.data

import kotlinx.coroutines.flow.Flow

interface ProductRepository {
	suspend fun addProduct(product : Product)

	suspend fun deleteProduct(product : Product)

	suspend fun getProductById(id:Int):Product?

	fun getAllProducts(): Flow<List<Product>>




}