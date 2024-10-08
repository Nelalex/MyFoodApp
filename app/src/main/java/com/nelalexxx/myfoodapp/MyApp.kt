package com.nelalexxx.myfoodapp

import android.app.Application
import com.nelalexxx.myfoodapp.viewModel.MenuRepository

class MyApp: Application() {

    companion object  {
        lateinit var  menuRepository: MenuRepository // чисто пока заглушка чтобы не было ошибки
    }

    override fun onCreate() {
        super.onCreate()
        menuRepository = MenuRepository.Base()
    }


}