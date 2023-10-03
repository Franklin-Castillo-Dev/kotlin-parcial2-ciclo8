package com.example.libdbthree.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.libdbthree.model.entity.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Query("SELECT * FROM product")
    fun getAll(): List<Product>

    @Query("SELECT * FROM product")
    fun getAllFlow(): Flow<List<Product>>

    @Query("SELECT * FROM product WHERE id IN (:productIds)")
    fun loadAllByIds(productIds: IntArray): List<Product>

    @Query("SELECT * FROM product WHERE name LIKE :name LIMIT 1")
    fun findByName(name: String): Product

    @Insert
    fun insertAll(vararg products: Product)

    @Delete
    fun delete(product: Product)

    @Query("DELETE FROM product")
    suspend fun deleteAll()
}