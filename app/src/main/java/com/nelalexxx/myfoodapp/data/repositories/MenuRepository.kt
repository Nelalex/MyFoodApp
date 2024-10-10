package com.nelalexxx.myfoodapp.data.repositories

import androidx.lifecycle.MutableLiveData
import com.nelalexxx.myfoodapp.R
import com.nelalexxx.myfoodapp.data.models.MenuItem

interface MenuRepository {
    val customMenuList: List<MenuItem>
    val customOrderList: MutableLiveData<MutableList<MenuItem>>
    var totalSum: Int

    fun addToOrder(menuItem: MenuItem)
    fun deleteFromOrder(menuItem: MenuItem)
    fun setMenuList(menuList: List<MenuItem>)

    object BaseData : MenuRepository {

        override var customMenuList: List<MenuItem> = listOf(
//          to see the diff between local and firebase data
//          MenuItem(R.drawable.kartofel, "НОВИНКА! Картофель сьедобный", 7777),
//          MenuItem(R.drawable.steik,"Хит продаж! Обычный стейк филе Миньон", 500),
            MenuItem(R.drawable.booter, "Бутерброд очень вкусный", 1000),
            MenuItem(R.drawable.pelmeni, "Пельмен очень пельменный", 2000),
            MenuItem(R.drawable.makaroni, "Мокарон очень много сосиска", 4000)
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
}




