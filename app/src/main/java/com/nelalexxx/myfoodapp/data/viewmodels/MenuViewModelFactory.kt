package com.nelalexxx.myfoodapp.data.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nelalexxx.myfoodapp.data.repositories.MenuRepository

class MenuViewModelFactory(val repository: MenuRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MenuViewModel::class.java)) {
            return MenuViewModel(repository) as T
        } else
            throw IllegalStateException("ERROR")
    }

}

