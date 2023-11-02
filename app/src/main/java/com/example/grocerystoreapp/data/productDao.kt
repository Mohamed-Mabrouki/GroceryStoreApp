package com.example.grocerystoreapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao{

	@Upsert
	suspend fun addProduct(product : Product)

	@Delete
	suspend fun deleteProduct(product : Product)

	@Query("SELECT * FROM Product where id=:id")
	suspend fun getProductById(id:Int):Product?



	@Query("SELECT * FROM Product")
	fun getAllProducts():Flow<List<Product>>

}