package com.dicoding.recordtrail

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.recordtrail.MainActivity
import com.google.android.material.button.MaterialButton

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_login)

        val btnLogin: MaterialButton = findViewById(R.id.btnLogin)
        val btnGoogleLogin: MaterialButton = findViewById(R.id.btnGoogleLogin)
        val btnFacebookLogin: MaterialButton = findViewById(R.id.btnFacebookLogin)
        val tvForgotPassword: View = findViewById(R.id.tvForgotPassword)
        val tvSignUp: View = findViewById(R.id.tvSignUp)

        btnLogin.setOnClickListener {
            Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()
            navigateToMain()
        }

        btnGoogleLogin.setOnClickListener {
            handleSocialLogin("Google")
        }

        btnFacebookLogin.setOnClickListener {
            handleSocialLogin("Facebook")
        }

        tvForgotPassword.setOnClickListener {
            Toast.makeText(this, "Fitur lupa password belum tersedia", Toast.LENGTH_SHORT).show()
        }

        tvSignUp.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }

    private fun handleSocialLogin(provider: String) {
        Toast.makeText(this, "Login dengan $provider berhasil", Toast.LENGTH_SHORT).show()
        navigateToMain()
    }

    private fun navigateToMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
