package com.nelalexxx.myfoodapp.ui.fragments.order

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nelalexxx.myfoodapp.R
import com.nelalexxx.myfoodapp.data.models.MenuItem
import com.nelalexxx.myfoodapp.data.viewmodels.MainViewModel
import com.nelalexxx.myfoodapp.databinding.OrderItemLayoutBinding

class OrderRVAdapter(
    var order: List<MenuItem>,
    private var viewModel: MainViewModel
) : RecyclerView.Adapter<OrderRVAdapter.OrderViewHolder>() { // adapter=recyclerview.adapter<viewholder>()

    inner class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // binding
        val binding = OrderItemLayoutBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.order_item_layout, parent, false)
        return OrderViewHolder(view)
    }

    override fun getItemCount(): Int {
        return order.size
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val menuItem = order[position]
        holder.binding.apply {
            foodImgV.setImageResource(menuItem.sourceId)
            descriptionTV.text = menuItem.descriptionText
            priceTV.text = "${menuItem.price} рублей"
            ammountTV.text = menuItem.count.toString()

            removeBtn.setOnClickListener {
                viewModel.deleteFromOrder(menuItem)
            }

            addBtn.setOnClickListener {
                viewModel.addToOrder(menuItem)
            }
        }
    }
}