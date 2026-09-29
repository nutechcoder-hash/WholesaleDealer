package com.example.wholesaledealer.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sales")
data class Sale(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val photoPath: String = "",
    val productName: String = "",
    val buyingPrice: Double = 0.0,
    val sellingPrice: Double = 0.0,
    val quantity: Int = 1,
    val totalProfit: Double = 0.0,
    val customerName: String = "",
    val customerPhone: String = "",
    val date: Long = System.currentTimeMillis()
)
