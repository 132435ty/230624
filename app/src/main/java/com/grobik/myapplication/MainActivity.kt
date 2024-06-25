package com.grobik.myapplication

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private lateinit var buttonsFragment: ButtonsFragment // привязываем фрагмент
    private lateinit var textsFragment: TextsFragment // привязываем фрагмент

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonsFragment = ButtonsFragment()
        textsFragment = TextsFragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, buttonsFragment)
            .hide(buttonsFragment)
            .add(R.id.fragmentContainer, textsFragment)
            .hide(textsFragment)
            .commit()


        val b1 = findViewById<Button>(R.id.b1)
        b1.setOnClickListener {

            showPreviousFragment()

        }

        val b2 = findViewById<Button>(R.id.b2)
        b2.setOnClickListener {// делаем кнопку нажимаемой

            showNextFragment()

        }
    }

    private fun showNextFragment() {
        val currentFragment = getCurrentFragment()
        val nextFragment = getNextFragment(currentFragment)

        supportFragmentManager.beginTransaction()
            .hide(currentFragment) // прячет текущ. фрагмент
            .show(nextFragment) // показывает следующий
            .commit()
    }

    private fun showPreviousFragment() {
        val currentFragment = getCurrentFragment()
        val previousFragment = getPreviousFragment(currentFragment)

        supportFragmentManager.beginTransaction()
            .hide(currentFragment) // прячет текущ. фрагмент
            .show(previousFragment) // показывает предыдущий фрагмент
            .commit()
    }

    private fun getCurrentFragment(): Fragment {
        val fragmentList = listOf(buttonsFragment, textsFragment) // лист фрагментов
        for (fragment in fragmentList) {
            if (fragment.isVisible) {
                return fragment // возврат текущего фрагмента
            }
        }
        return buttonsFragment // возврат к 1 фрагменту
    }

    private fun getNextFragment(currentFragment: Fragment): Fragment {
        val fragmentList = listOf(buttonsFragment, textsFragment) // лист
        val currentIndex =
            fragmentList.indexOf(currentFragment) // приравнение к идексу фрагмента в списке
        val nextIndex =
            (currentIndex + 1) % fragmentList.size // приравнение к идексу следующего фрагмента в списке
        return fragmentList[nextIndex]
    }

    private fun getPreviousFragment(currentFragment: Fragment): Fragment {
        val fragmentList = listOf(buttonsFragment, textsFragment)
        val currentIndex =
            fragmentList.indexOf(currentFragment) // приравнение к идексу фрагмента в списке
        val previousIndex =
            if (currentIndex == 0) fragmentList.size - 1 else currentIndex - 1 // приравнение к идексу  предыдущего фрагмента в списке или первого фрагмента
        return fragmentList[previousIndex]
    }
}
