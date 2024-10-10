package com.nelalexxx.myfoodapp.ui.fragments.menu

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.nelalexxx.myfoodapp.R
import com.nelalexxx.myfoodapp.data.models.MenuItem
import com.nelalexxx.myfoodapp.data.viewmodels.MainViewModel
import com.nelalexxx.myfoodapp.databinding.MenuItemLayoutBinding


class MenuRVAdapter(
    private var menu: List<MenuItem>,
    private var viewModel: MainViewModel
) : RecyclerView.Adapter<MenuRVAdapter.MenuViewHolder>() {
    inner class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // binding
        val binding = MenuItemLayoutBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.menu_item_layout, parent, false)
        return MenuViewHolder(view)
    }

    override fun getItemCount(): Int {
        return menu.size
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val menuItem = menu[position]
        holder.binding.apply {
            foodImgV.setImageResource(menuItem.sourceId)
            descriptionTV.text = menuItem.descriptionText
            priceTV.text = "${menuItem.price} рублей"

            addToOrderBtn.setOnClickListener {
                viewModel.addToOrder(menuItem)
                //notification
                Snackbar.make(it, "Добавлено в заказ", Snackbar.LENGTH_SHORT).apply {
                    view.layoutParams = (view.layoutParams as FrameLayout.LayoutParams).apply {
                        gravity = Gravity.BOTTOM
                        bottomMargin = 200 // Set the bottom margin to 200 pixels
                    }
                    show()
                }
            }
        }
    }
}