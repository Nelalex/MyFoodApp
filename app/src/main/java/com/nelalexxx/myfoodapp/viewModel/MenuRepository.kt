package com.nelalexxx.myfoodapp.viewModel

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
        var customOrderList: MutableList<MenuItem> = mutableListOf()
    }
    override fun addToOrder(menuItem: MenuItem) {
        customOrderList.add(menuItem)
    }

    override fun deleteFromOrder() {
        if (customOrderList.isNotEmpty())
            customOrderList.removeAt(customOrderList.lastIndex)
    }


}

}
