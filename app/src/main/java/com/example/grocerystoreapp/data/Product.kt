package com.example.grocerystoreapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product (
	@PrimaryKey val  id : Int? = null,
	val name :String,
	val price :String,
	val quantity :String,

)