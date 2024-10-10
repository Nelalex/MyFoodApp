package com.nelalexxx.myfoodapp.ui.fragments.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.nelalexxx.myfoodapp.data.repositories.MenuRepository
import com.nelalexxx.myfoodapp.data.viewmodels.MainViewModel
import com.nelalexxx.myfoodapp.databinding.MenuFragmentLayoutBinding
import com.nelalexxx.myfoodapp.ui.fragments.BindingFragment

class MenuFragment : BindingFragment<MenuFragmentLayoutBinding>(){
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = MenuFragmentLayoutBinding::inflate
    private val viewModel: MainViewModel by activityViewModels() // Use activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //adapter
        val adapter = MenuRVAdapter(MenuRepository.Base.customMenuList, viewModel)
        binding.menuRV.apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(this@MenuFragment.context)
        }
    }
}