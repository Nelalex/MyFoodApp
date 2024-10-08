package com.nelalexxx.myfoodapp.fragments.menu

import com.nelalexxx.myfoodapp.R
import com.nelalexxx.myfoodapp.databinding.MenuItemLayoutBinding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nelalexxx.myfoodapp.MyApp.Companion.menuRepository
import com.nelalexxx.myfoodapp.fragments.MenuItem


// now we need do understand which data it should set to which data
//we created a data class and now can access him from constructor
class MenuRVAdapter (
    var menu: List<MenuItem>
): RecyclerView.Adapter<MenuRVAdapter.MenuViewHolder>() { // adapter=recyclerview.adapter<viewholder>()
    // inner class is viewholder = must hold views for recycler view
    // parameter is a layout(view) that we need as an item in recycler view
    // we must return standart object for recycler view thats why we inherit
    // from .viewholder  : RecyclerView.ViewHolder(itemView)
    inner class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // этот код пишем если хотим исопльзовать viewBinding для обновления ui
        val binding = MenuItemLayoutBinding.bind(itemView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        //inflate as an activity main. we have parent parameter to context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.menu_item_layout, parent, false)
        //so we inflate in recyclerview layout inflate(int resource, android.view.ViewGroup root, boolean attachToRoot)
        return MenuViewHolder(view)
    }

    override fun getItemCount(): Int {
        return menu.size // number of existing elements in recyclerview
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val menuItem = menu[position]
        holder.binding.apply {
            foodImgV.setImageResource(menuItem.sourceId)
            descriptionTV.text = menuItem.descriptionText
            priceTV.text = "${menuItem.price} рублей"

            addToOrderBtn.setOnClickListener {
                menuRepository.addToOrder(menuItem)
            }
        }

    }



}