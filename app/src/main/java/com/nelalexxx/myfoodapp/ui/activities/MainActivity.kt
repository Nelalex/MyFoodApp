package com.nelalexxx.myfoodapp.ui.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.firebase.Firebase
import com.google.firebase.storage.storage
import com.google.firebase.storage.storageMetadata
import com.nelalexxx.myfoodapp.R
import com.nelalexxx.myfoodapp.data.repositories.MenuRepository
import com.nelalexxx.myfoodapp.data.viewmodels.MainViewModel
import com.nelalexxx.myfoodapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

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
        viewModel.init(savedInstanceState, navController)
        //Observe
        viewModel.repository.customOrderList.observe(this) { updatedOrderList ->
            viewModel.changeTotalSum(updatedOrderList)
            badge.number = viewModel.repository.totalSum
            badge.isVisible = viewModel.repository.totalSum > 0
            badge.maxCharacterCount = 6
        }
    }

}
