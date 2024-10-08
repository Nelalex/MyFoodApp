package com.nelalexxx.myfoodapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.nelalexxx.myfoodapp.databinding.ActivityMainBinding
import com.nelalexxx.myfoodapp.fragments.MenuFragment
import com.nelalexxx.myfoodapp.fragments.OrderFragment
import com.nelalexxx.myfoodapp.viewModel.MenuRepository
import com.nelalexxx.myfoodapp.viewModel.MenuViewModel
import com.nelalexxx.myfoodapp.viewModel.MenuViewModelFactory

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var randomRep = MenuRepository() // чисто пока заглушка чтобы не было ошибки
        val viewModelFactory = MenuViewModelFactory(randomRep)
        val myViewModel = ViewModelProvider(this,/*толкьо если есть фабрика*/ viewModelFactory)[MenuViewModel::class.java]

        // Вначале берем контейнер где будет заменять fragment и инициализируем как NavHostFragment
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.mainFrame) as NavHostFragment
        // Тут мы иницилизируем навигацию (то есть его actions)  NavigationComponent
        val navController = navHostFragment.navController


        // Связываем BottomNavigationView с NavController
        NavigationUI.setupWithNavController(binding.bottomNavMenu, navController)





    }


}