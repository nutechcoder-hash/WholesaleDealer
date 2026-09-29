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

    // We use a MutableStateFlow to hold the list, and update it manually
    private val _sales = MutableStateFlow<List<Sale>>(emptyList())
    val sales: StateFlow<List<Sale>> = _sales.asStateFlow()

    init {
        // Load the sales when the ViewModel is created
        loadSales()
    }

    fun loadSales() {
        viewModelScope.launch {
            // This suspend function runs on a background thread automatically
            _sales.value = dao.getAllSales()
        }
    }

    fun addSale(sale: Sale) = viewModelScope.launch {
        dao.insertSale(sale)
        // After inserting, reload the list
        _sales.value = dao.getAllSales()
    }
}
