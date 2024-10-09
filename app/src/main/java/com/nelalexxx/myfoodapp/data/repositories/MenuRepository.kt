package com.nelalexxx.myfoodapp.data.repositories

import androidx.lifecycle.MutableLiveData
import com.nelalexxx.myfoodapp.R
import com.nelalexxx.myfoodapp.data.models.MenuItem

interface MenuRepository {

    fun addToOrder(menuItem: MenuItem)
    fun deleteFromOrder(menuItem: MenuItem)



class Base  : MenuRepository {

    companion object {
        val customMenuList: List<MenuItem> = listOf(
            MenuItem(R.drawable.booter, "Бутерброд очень вкусный", 1000),
            MenuItem(R.drawable.pelmeni, "Пельмен очень вкусный", 2000),
            MenuItem(R.drawable.makaroni, "Мокарон очень вкусний", 4000)
        )

        val customOrderList = MutableLiveData<MutableList<MenuItem>>(mutableListOf())
    }
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
        val existingItem = currentList.find { it.sourceId== menuItem.sourceId }
        if (existingItem != null) {
            if (existingItem.count > 1) {
                existingItem.count-- // Decrement count if greater than 1
            } else {
                currentList.remove(existingItem) // Remove item if count is 1
            }
            customOrderList.postValue(currentList)
        }
    }


}

}
