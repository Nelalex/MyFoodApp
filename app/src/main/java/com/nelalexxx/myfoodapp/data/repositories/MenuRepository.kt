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

}




