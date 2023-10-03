package com.example.di.navigation.moduloroomdinavcompose.di

import com.example.di.navigation.libdbtwo.dao.UserDao
import com.example.di.navigation.libdbtwo.repository.UserRepository
import com.example.libdbthree.dao.ProductDao
import com.example.libdbthree.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesUserRepository(userDao: UserDao): UserRepository= UserRepository(userDao)

    @Provides
    @Singleton
    fun providesProductRepository(productDao: ProductDao): ProductRepository= ProductRepository(productDao)
}