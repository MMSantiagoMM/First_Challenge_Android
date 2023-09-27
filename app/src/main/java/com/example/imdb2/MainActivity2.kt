package com.example.imdb2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import com.example.imdb2.databinding.ActivityMain2Binding
import com.example.imdb2.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(BeginingFragment())

        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.begining -> replaceFragment(BeginingFragment())
                R.id.search -> replaceFragment(SearchFragment())
                R.id.play -> replaceFragment(PlayFragment())
                R.id.account -> replaceFragment(AccountFragment())
                else->{}
            }
            true
        }
    }

    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }




}