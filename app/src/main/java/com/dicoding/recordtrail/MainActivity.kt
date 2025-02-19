package com.dicoding.recordtrail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.dicoding.recordtrail.ui.navigator.NavigatorFragment
import com.dicoding.recordtrail.ui.profile.ProfileFragment
import com.dicoding.recordtrail.ui.recordtrail.RecordTrailFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_navigator -> {
                    loadFragment(NavigatorFragment(), "Navigator")
                    true
                }
                R.id.navigation_profile -> {
                    loadFragment(ProfileFragment(), "Profile")
                    true
                }
                R.id.navigation_record_trail -> {
                    loadFragment(RecordTrailFragment(), "Record Trail")
                    true
                }
                else -> false
            }
        }

        // Set default fragment saat aplikasi pertama kali dibuka
        if (savedInstanceState == null) {
            bottomNavigationView.selectedItemId = R.id.navigation_navigator
        }
    }

    private fun loadFragment(fragment: Fragment, title: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()

        // Ubah title di ActionBar
        supportActionBar?.title = title
    }
}
