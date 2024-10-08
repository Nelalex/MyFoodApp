package com.nelalexxx.myfoodapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.nelalexxx.myfoodapp.databinding.ActivityMainBinding
import com.nelalexxx.myfoodapp.fragments.MenuFragment
import com.nelalexxx.myfoodapp.fragments.OrderFragment

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // раньше инициализировали фрагменты и использовали .replace и .setOnItemSelectedListener{}
        // но сейчас best practise использовать navigation component


        // Вначале берем контейнер где будет заменять fragment и инициализируем как NavHostFragment
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.mainFrame) as NavHostFragment
        // Тут мы иницилизируем навигацию (то есть его actions)  NavigationComponent
        val navController = navHostFragment.navController


        // Связываем BottomNavigationView с NavController
        NavigationUI.setupWithNavController(binding.bottomNavMenu, navController)


        // Главное чтобы при создании menu для BottomNavigation мы связали нормально id Фрагментов с item
        // Чтобы навигация понимала какая иконка соответствует какому фрагменту
        // Если мы говорим про bottom navigation она всесторонняя поэтому мы должны связать связми в nav_grpah  каждый fragment друг с другом


    }


}