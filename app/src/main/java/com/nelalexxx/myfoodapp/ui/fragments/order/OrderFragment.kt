package com.nelalexxx.myfoodapp.ui.fragments.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.nelalexxx.myfoodapp.databinding.OrderFragmentLayoutBinding
import com.nelalexxx.myfoodapp.ui.fragments.BindingFragment
import com.nelalexxx.myfoodapp.data.repositories.MenuRepository

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

            val sum = updatedOrderList.sumOf { it.count * it.price }
            binding.sumTV.text = "Сумма: $sum рублей\nСО СКИДКОЙ ДЛЯ ОЛЕГА: ${sum/3} РУБЛЯ"

        }

    }

}
