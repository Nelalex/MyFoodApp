package com.nelalexxx.myfoodapp.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.nelalexxx.myfoodapp.R
import com.nelalexxx.myfoodapp.databinding.ActivityMainBinding
import com.nelalexxx.myfoodapp.data.repositories.MenuRepository

class MainActivity : AppCompatActivity() {

    // Для RecyclerView, что нам надо?
    // Adapter
    // Data class который будет иницилилзиировать значения для обьектов

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        val viewModelFactory = MenuViewModelFactory(randomRep)
//        val myViewModel = ViewModelProvider(this,/*толкьо если есть фабрика*/ viewModelFactory)[MenuViewModel::class.java]

        // Вначале берем контейнер где будет заменять fragment и инициализируем как NavHostFragment
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.mainFrame) as NavHostFragment
        // Тут мы иницилизируем навигацию (то есть его actions)  NavigationComponent
        val navController = navHostFragment.navController


        // Связываем BottomNavigationView с NavController
        NavigationUI.setupWithNavController(binding.bottomNavMenu, navController)

        binding.bottomNavMenu.getOrCreateBadge(R.id.orderFragment)


        val badge = binding.bottomNavMenu.getOrCreateBadge(R.id.orderFragment)



        MenuRepository.Base.customOrderList.observe(this) { updatedOrderList ->
            val totalSum = updatedOrderList.sumOf { it.count * it.price }
            badge.number = totalSum
            badge.isVisible = totalSum > 0
            badge.maxCharacterCount = 6
        }






    }


}
