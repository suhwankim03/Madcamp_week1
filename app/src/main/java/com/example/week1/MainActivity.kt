package com.example.week1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
    private val gallery = Gallery()
    private val contact = Contact()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.containers, contact).commit()

        val navigationBarView = findViewById<NavigationBarView>(R.id.bottom_navigationview)
        navigationBarView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.contact -> {
                    supportFragmentManager.beginTransaction().replace(R.id.containers, contact).commit()
                    true
                }
                R.id.gallery -> {
                    supportFragmentManager.beginTransaction().replace(R.id.containers, gallery).commit()
                    true
                }
                else -> false
            }
        }
    }
}
