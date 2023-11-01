package com.example.grocerystoreapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao{

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun addProduct(product : Product)

	@Delete
	suspend fun deleteProduct(product : Product)

	@Query("SELECT * FROM Product")
	fun getAllProducts():Flow<List<Product>>

}