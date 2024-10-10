package com.nelalexxx.myfoodapp.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.nelalexxx.myfoodapp.R
import com.nelalexxx.myfoodapp.data.repositories.MenuRepository
import com.nelalexxx.myfoodapp.data.viewmodels.MainViewModel
import com.nelalexxx.myfoodapp.data.viewmodels.MenuViewModelFactory
import com.nelalexxx.myfoodapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Fragments
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.mainFrame) as NavHostFragment
        //Navigation
        val navController = navHostFragment.navController
        NavigationUI.setupWithNavController(binding.bottomNavMenu, navController)
        //Badge
        binding.bottomNavMenu.getOrCreateBadge(R.id.orderFragment)
        val badge = binding.bottomNavMenu.getOrCreateBadge(R.id.orderFragment)
        //viewModel
        val viewModelFactory = MenuViewModelFactory(MenuRepository.BaseData)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        viewModel.init(savedInstanceState, navController)
        //Observe
        MenuRepository.BaseData.customOrderList.observe(this) { updatedOrderList ->
            viewModel.changeTotalSum(updatedOrderList)
            badge.number = MenuRepository.BaseData.totalSum
            badge.isVisible = MenuRepository.BaseData.totalSum > 0
            badge.maxCharacterCount = 6
        }
    }
}
