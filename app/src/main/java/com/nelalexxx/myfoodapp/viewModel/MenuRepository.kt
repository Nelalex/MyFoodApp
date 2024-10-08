package com.nelalexxx.myfoodapp.viewModel

import androidx.lifecycle.MutableLiveData
import com.nelalexxx.myfoodapp.R
import com.nelalexxx.myfoodapp.fragments.MenuItem

interface MenuRepository {

    fun addToOrder(menuItem: MenuItem)
    fun deleteFromOrder()



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
        currentList.add(menuItem)
        customOrderList.postValue(currentList)
    }

    override fun deleteFromOrder() {
        val currentList = customOrderList.value ?: mutableListOf()
        if (currentList.isNotEmpty())
            currentList.removeAt(currentList.lastIndex)
        customOrderList.postValue(currentList)
    }


}

}
