package com.nelalexxx.myfoodapp.fragments.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.nelalexxx.myfoodapp.databinding.MenuFragmentLayoutBinding
import com.nelalexxx.myfoodapp.fragments.BindingFragment
import com.nelalexxx.myfoodapp.viewModel.MenuRepository

class MenuFragment : BindingFragment<MenuFragmentLayoutBinding>(){
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = MenuFragmentLayoutBinding::inflate


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        // Обязательная штука подключения адаптера
        val adapter = MenuRVAdapter(MenuRepository.Base.customMenuList)
        binding.menuRV.apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(this@MenuFragment.context)
        }




    }
}