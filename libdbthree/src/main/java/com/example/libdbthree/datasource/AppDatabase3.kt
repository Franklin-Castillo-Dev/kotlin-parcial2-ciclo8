package com.example.libdbthree.datasource

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.libdbthree.dao.ProductDao
import com.example.libdbthree.model.entity.Product

@Database(entities = [Product::class], version = 1)
abstract class AppDatabase3 : RoomDatabase() {

    abstract fun productDao(): ProductDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AppDatabase3? = null

        fun getDatabase(context: Context): AppDatabase3 {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase3::class.java,
                    "my_database3"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}