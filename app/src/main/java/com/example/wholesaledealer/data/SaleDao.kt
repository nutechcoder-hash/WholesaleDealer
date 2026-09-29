package com.example.wholesaledealer.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface SaleDao {
    // This is now a suspend function (one-time async read)
    @Query("SELECT * FROM sales ORDER BY date DESC")
    suspend fun getAllSales(): List<Sale>

    @Insert
    suspend fun insertSale(sale: Sale): Long
}
