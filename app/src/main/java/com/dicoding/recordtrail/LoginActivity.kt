package com.dicoding.recordtrail

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnLogin: MaterialButton = findViewById(R.id.btnLogin)
        val btnGoogleLogin: MaterialButton = findViewById(R.id.btnGoogleLogin)
        val btnFacebookLogin: MaterialButton = findViewById(R.id.btnFacebookLogin)
        val etEmail: TextInputEditText = findViewById(R.id.etEmail)
        val etPassword: TextInputEditText = findViewById(R.id.etPassword)
        val tvForgotPassword: View = findViewById(R.id.tvForgotPassword)
        val tvSignUp: View = findViewById(R.id.tvSignUp)

        btnLogin.setOnClickListener {
            if (validateInput()) {
                Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()
                navigateToMain()
            }
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

    private fun validateInput(): Boolean {
        val email = findViewById<TextInputEditText>(R.id.etEmail).text.toString()
        val password = findViewById<TextInputEditText>(R.id.etPassword).text.toString()

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Email tidak valid", Toast.LENGTH_SHORT).show()
            return false
        }

        if (password.length < 6) {
            Toast.makeText(this, "Password minimal 6 karakter", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    private fun handleSocialLogin(provider: String) {
        Toast.makeText(this, "Login dengan $provider berhasil", Toast.LENGTH_SHORT).show()
        navigateToMain()
    }

    private fun navigateToMain() {
        val intent = Intent(this, NavigatorActivity::class.java)
        startActivity(intent)
        finish()
    }
}