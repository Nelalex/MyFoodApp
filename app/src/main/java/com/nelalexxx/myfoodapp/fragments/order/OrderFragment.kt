package com.nelalexxx.myfoodapp.fragments.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.nelalexxx.myfoodapp.MyApp.Companion.menuRepository
import com.nelalexxx.myfoodapp.databinding.OrderFragmentLayoutBinding
import com.nelalexxx.myfoodapp.fragments.BindingFragment
import com.nelalexxx.myfoodapp.viewModel.MenuRepository

class OrderFragment : BindingFragment<OrderFragmentLayoutBinding>(){
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = OrderFragmentLayoutBinding::inflate


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        // Обязательная штука подключения адаптера
        val adapter = OrderRVAdapter(MenuRepository.Base.customOrderList.value!!)
        binding.menuRV.apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(this@OrderFragment.context)

        }

        // В вашем OrderFragment
        MenuRepository.Base.customOrderList.observe(viewLifecycleOwner) { updatedOrderList ->
            adapter.order = updatedOrderList
            adapter.notifyDataSetChanged()
        }


    }


}
