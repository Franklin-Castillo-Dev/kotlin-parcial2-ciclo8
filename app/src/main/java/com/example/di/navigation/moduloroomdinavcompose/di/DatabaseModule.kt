package com.example.di.navigation.moduloroomdinavcompose.di

import android.content.Context
import com.example.di.navigation.libdbtwo.datasource.AppDatabase
import com.example.libdbthree.datasource.AppDatabase3
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesAppDatabase(@ApplicationContext context: Context): AppDatabase= AppDatabase.getDatabase(context)

    @Provides
    @Singleton
    fun providesAppDatabase3(@ApplicationContext context: Context): AppDatabase3= AppDatabase3.getDatabase(context)

}