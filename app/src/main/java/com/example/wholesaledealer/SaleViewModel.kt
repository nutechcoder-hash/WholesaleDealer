package com.example.wholesaledealer

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.wholesaledealer.data.AppDatabase
import com.example.wholesaledealer.data.Sale
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class SaleViewModel(app: Application) : AndroidViewModel(app) {
    private val dao = AppDatabase.getDatabase(app).saleDao()
    val sales: StateFlow<List<Sale>> = dao.getAllSales()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())
    fun addSale(sale: Sale) = viewModelScope.launch { dao.insertSale(sale) }
}
