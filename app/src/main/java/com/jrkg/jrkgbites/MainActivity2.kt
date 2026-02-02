package com.jrkg.jrkgbites

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val isUserLoggedIn = false // This logic will need to be properly implemented later

        if (savedInstanceState == null) {
            if (isUserLoggedIn) {
                Toast.makeText(this,
                    "User is Logged in. Navigate to Dashboard View.",
                    Toast.LENGTH_SHORT).show()
                loadLoginFragment()
            } else {
                // Show LoginFragment if not logged in
                loadLoginFragment()
            }
        }
    }

    private fun loadLoginFragment() {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_content_fragment_container, LoginFragment())
        transaction.commit()
    }
}