package com.nelalexxx.myfoodapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.viewbinding.ViewBinding
import com.nelalexxx.myfoodapp.databinding.MenuFragmentLayoutBinding

class MenuFragment : BindingFragment<MenuFragmentLayoutBinding>(){
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = MenuFragmentLayoutBinding::inflate


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}