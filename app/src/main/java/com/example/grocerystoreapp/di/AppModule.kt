package com.example.grocerystoreapp.di

import android.app.Application
import androidx.room.Room
import com.example.grocerystoreapp.data.ProductDatabase
import com.example.grocerystoreapp.data.ProductRepository
import com.example.grocerystoreapp.data.ProductRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
	@Provides
	@Singleton
	fun provideProductDatabase(app : Application) : ProductDatabase {
		return Room.databaseBuilder(
			context = app, klass = ProductDatabase::class.java, name = "product_db"
		).fallbackToDestructiveMigration().build()
	}
	@Provides
	@Singleton
	fun providesDataBaseRepository(db : ProductDatabase) : ProductRepository {
		return ProductRepositoryImpl(db.dao)

	}


}