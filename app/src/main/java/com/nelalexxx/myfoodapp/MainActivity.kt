package com.nelalexxx.myfoodapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.nelalexxx.myfoodapp.databinding.ActivityMainBinding

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







    }


}

/*
        // можно сделать пустой лист , можно потом подгружать с бд
        // место где хранятся значения для ui
        var todoList = mutableListOf(
            ToDo("KEKW", false),
            ToDo("KEKW2", true)
        )
        // Обязательная штука подключения адаптера
        val adapter = TodoAdapter(todoList)
        binding.rvToDo.apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        binding.AddBtn.setOnClickListener {
            // нам нужен обьект класса to do который мы просто добавим в лист
            val title = binding.ToDoEdit.text.toString()
            val todo = ToDo(title, false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size - 1)
            // есть аналог adapter.notifyDataSetChanged но он обновляет все эжлементы RecyclerView
            // а этот обновляет один
        }
 */