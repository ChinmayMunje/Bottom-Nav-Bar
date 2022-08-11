package com.gtappdevelopers.bottomnavbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val homeFragment = HomeFragment()
        val accountFragment = AccountFragment()
        val settingsFragment = SettingsFragment()

        this.supportFragmentManager.beginTransaction().replace(R.id.idFLFragment, accountFragment).commit()
        setCurrentFragment(homeFragment)
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_item_home -> setCurrentFragment(homeFragment)
                R.id.nav_item_account -> setCurrentFragment(accountFragment)
                R.id.nav_item_settings -> setCurrentFragment(settingsFragment)
            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment) =
            supportFragmentManager.beginTransaction().replace(R.id.idFLFragment, fragment).commit()


}