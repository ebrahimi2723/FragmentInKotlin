package com.example.fragmentinkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    lateinit var frameLayout:FrameLayout
    lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init(){
        bindViews()

        bottomNavigationView.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.fragmentA ->{
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.frame_layout,A())
                    transaction.commit()
                    true
                }
                R.id.fragmentB -> {
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.frame_layout,B())
                    transaction.commit()
                    true
                }
                else -> false
            }
        }
    }
    private fun bindViews(){
        frameLayout = findViewById(R.id.frame_layout)
        bottomNavigationView = findViewById(R.id.bottom_navigation)
    }

}