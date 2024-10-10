package com.nelalexxx.myfoodapp.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.nelalexxx.myfoodapp.R
import com.nelalexxx.myfoodapp.data.repositories.MenuRepository
import com.nelalexxx.myfoodapp.data.repositories.MenuRepository.Base.Companion.totalSum
import com.nelalexxx.myfoodapp.data.viewmodels.MainViewModel
import com.nelalexxx.myfoodapp.data.viewmodels.MenuViewModelFactory
import com.nelalexxx.myfoodapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //viewModel
        val viewModelFactory = MenuViewModelFactory(MenuRepository.Base())
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        //Fragments
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.mainFrame) as NavHostFragment
        //Navigation
        val navController = navHostFragment.navController
        NavigationUI.setupWithNavController(binding.bottomNavMenu, navController)
        //Badge
        binding.bottomNavMenu.getOrCreateBadge(R.id.orderFragment)
        val badge = binding.bottomNavMenu.getOrCreateBadge(R.id.orderFragment)
        //Observe
        MenuRepository.Base.customOrderList.observe(this) { updatedOrderList ->
            viewModel.changeTotalSum(updatedOrderList)
            badge.number = totalSum
            badge.isVisible = totalSum > 0
            badge.maxCharacterCount = 6
        }
    }
}
