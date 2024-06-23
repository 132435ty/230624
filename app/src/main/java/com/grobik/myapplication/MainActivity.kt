package com.grobik.myapplication

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private lateinit var buttonsFragment: ButtonsFragment
    private lateinit var textsFragment: TextsFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonsFragment = ButtonsFragment()
        textsFragment = TextsFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, buttonsFragment)
            commit()
        }

        val b1 = findViewById<Button>(R.id.b1)
        b1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainer, buttonsFragment)
                commit()
            }
        }

        val b2 = findViewById<Button>(R.id.b2)
        b2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainer, textsFragment)
                commit()
            }
        }
    }
}