package com.nelalexxx.myfoodapp.data.repositories

import androidx.lifecycle.MutableLiveData
import com.nelalexxx.myfoodapp.R
import com.nelalexxx.myfoodapp.data.models.MenuItem
import javax.inject.Inject

class MenuRepositoryImpl @Inject constructor() : MenuRepository {

    override var customMenuList: List<MenuItem> = listOf(
        // to see the diff between local and firebase data
        // MenuItem(R.drawable.kartofel, "НОВИНКА! Картофель сьедобный", 7777),
        // MenuItem(R.drawable.steik,"Хит продаж! Обычный стейк филе Миньон", 500),
        MenuItem(R.drawable.booter, "Бутерброд c вкуснейшей колбасой", 1000),
        MenuItem(R.drawable.pelmeni, "Пельмени как у бабушки", 2000),
        MenuItem(R.drawable.makaroni, "Те самые макароны с сосикой", 4000)
    )
    override val customOrderList = MutableLiveData<MutableList<MenuItem>>(mutableListOf())
    override var totalSum: Int = 0

    override fun addToOrder(menuItem: MenuItem) {
        val currentList = customOrderList.value ?: mutableListOf()
        val existingItem = currentList.find { it.sourceId == menuItem.sourceId }
        if (existingItem != null) {
            existingItem.count++ // Increment count if item exists
        } else {
            menuItem.count = 1 // Initialize count for new item
            currentList.add(menuItem)
        }
        customOrderList.postValue(currentList)
    }

    override fun deleteFromOrder(menuItem: MenuItem) {
        val currentList = customOrderList.value ?: mutableListOf()
        val existingItem = currentList.find { it.sourceId == menuItem.sourceId }
        if (existingItem != null) {
            if (existingItem.count > 1) {
                existingItem.count-- // Decrement count if greater than 1
            } else {
                currentList.remove(existingItem) // Remove item if count is 1
            }
            customOrderList.postValue(currentList)
        }
    }

    override fun setMenuList(menuList: List<MenuItem>) {
        this.customMenuList = menuList
    }
}