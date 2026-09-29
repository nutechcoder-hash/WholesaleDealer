package com.example.wholesaledealer.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface SaleDao {
    @Query("SELECT * FROM sales ORDER BY date DESC")
    fun getAllSales(): Flow<List<Sale>>

    @Insert
    suspend fun insertSale(sale: Sale): Long
}
