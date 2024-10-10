package com.nelalexxx.myfoodapp.data.viewmodels

import androidx.lifecycle.ViewModel
import com.nelalexxx.myfoodapp.data.models.MenuItem
import com.nelalexxx.myfoodapp.data.repositories.MenuRepository
import com.nelalexxx.myfoodapp.data.repositories.MenuRepository.Base.Companion.totalSum

class MainViewModel(val repository: MenuRepository) : ViewModel() {

    fun changeTotalSum(pricesList: MutableList<MenuItem>) {
        totalSum = pricesList.sumOf { it.count * it.price }
    }

    fun addToOrder(menuItem: MenuItem) {
        repository.addToOrder(menuItem)
    }

    fun deleteFromOrder(menuItem: MenuItem) {
        repository.deleteFromOrder(menuItem)
    }
}