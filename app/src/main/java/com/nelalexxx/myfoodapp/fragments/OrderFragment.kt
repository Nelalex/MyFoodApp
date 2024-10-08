package com.nelalexxx.myfoodapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.viewbinding.ViewBinding
import com.nelalexxx.myfoodapp.databinding.OrderFragmentLayoutBinding

class OrderFragment : BindingFragment<OrderFragmentLayoutBinding>(){
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = OrderFragmentLayoutBinding::inflate


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
