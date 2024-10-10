package com.nelalexxx.myfoodapp.data.viewmodels

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.google.firebase.Firebase
import com.google.firebase.storage.storage
import com.nelalexxx.myfoodapp.R
import com.nelalexxx.myfoodapp.data.models.MenuItem
import com.nelalexxx.myfoodapp.data.repositories.MenuRepository
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withTimeout


class MainViewModel(private val repository: MenuRepository) : ViewModel() {

    fun changeTotalSum(pricesList: MutableList<MenuItem>) {
        MenuRepository.BaseData.totalSum = pricesList.sumOf { it.count * it.price }
    }

    fun addToOrder(menuItem: MenuItem) {
        repository.addToOrder(menuItem)
    }

    fun deleteFromOrder(menuItem: MenuItem) {
        repository.deleteFromOrder(menuItem)
    }

    private suspend fun setupMenuData() {
        val storage = Firebase.storage
        val listRef = storage.reference.child("images")
        val menuItems = mutableListOf<MenuItem>()

        try {
            withTimeout(5000) {
                val listResult = listRef.listAll().await() // Ожидаем listAll()
                for (itemRef in listResult.items) {
                    val metadata = itemRef.metadata.await() // Ожидаем metadata
                    val descriptionText = metadata.getCustomMetadata("descriptionText")
                    val price = metadata.getCustomMetadata("price")?.toIntOrNull()
                    val menuItem = MenuItem(
                        sourceId = itemRef.name.toIntOrNull() ?: 0,
                        descriptionText = descriptionText ?: "",
                        price = price ?: 0
                    )
                    menuItems.add(menuItem)
                }
                if (menuItems.isNotEmpty())
                    MenuRepository.BaseData.setMenuList(menuItems)
            }
        } catch (e: TimeoutCancellationException) {
            Log.d("TEST", "Данные слишком долго подгружаются, загружаем из памяти")
        }
    }

    fun init(savedInstanceState: Bundle?, navController: NavController) {
        // Download menu from firebase datastore or set base menu
        if (savedInstanceState == null) {
            viewModelScope.launch {
                this@MainViewModel.setupMenuData()
                navController.navigate(
                    R.id.menuFragment,
                    null,
                    NavOptions.Builder()
                        .setPopUpTo(R.id.loadingFragment, true)
                        .build()
                )
            }
        }
    }
}