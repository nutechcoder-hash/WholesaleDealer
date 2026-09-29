package com.example.wholesaledealer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    private val vm: SaleViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val sales by vm.sales.collectAsState()
                Column(Modifier.padding(16.dp)) {
                    Text("Wholesale Dealer", style = MaterialTheme.typography.headlineMedium)
                    Spacer(Modifier.height(16.dp))
                    LazyColumn {
                        items(sales) { s ->
                            Text("${s.customerName}: ${s.totalProfit}")
                        }
                    }
                }
            }
        }
    }
}
