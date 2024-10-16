package com.nelalexxx.myfoodapp.ui.fragments.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.nelalexxx.myfoodapp.data.repositories.MenuRepository
import com.nelalexxx.myfoodapp.data.viewmodels.MainViewModel
import com.nelalexxx.myfoodapp.databinding.OrderFragmentLayoutBinding
import com.nelalexxx.myfoodapp.ui.fragments.BindingFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OrderFragment : BindingFragment<OrderFragmentLayoutBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = OrderFragmentLayoutBinding::inflate
    private val viewModel: MainViewModel by activityViewModels() // Use activityViewModels()

    @Inject
    lateinit var menuRepository: MenuRepository // Внедряем MenuRepository

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = OrderRVAdapter(menuRepository.customOrderList.value!!, viewModel)
        binding.menuRV.apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(this@OrderFragment.context)
        }

        menuRepository.customOrderList.observe(viewLifecycleOwner) { updatedOrderList ->
            adapter.order = updatedOrderList
            adapter.notifyDataSetChanged()

            val sum = updatedOrderList.sumOf { it.count * it.price }
            binding.sumTV.text = "Сумма: $sum рублей"
        }
    }
}
