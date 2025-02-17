package com.dicoding.recordtrail

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import android.widget.TextView

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // Inisialisasi komponen dengan ID yang benar
        val btnSignUp: MaterialButton = findViewById(R.id.btnSignUp)
        val etFirstName: TextInputEditText = findViewById(R.id.etFirstName)
        val etLastName: TextInputEditText = findViewById(R.id.etLastName)
        val etEmail: TextInputEditText = findViewById(R.id.etEmail)
        val etPassword: TextInputEditText = findViewById(R.id.etPassword)
        val tvLogin: TextView = findViewById(R.id.tvLogin)

        btnSignUp.setOnClickListener {
            if (validateInput(
                    etFirstName.text.toString(),
                    etLastName.text.toString(),
                    etEmail.text.toString(),
                    etPassword.text.toString()
                )) {
                Toast.makeText(this, "Sign Up berhasil", Toast.LENGTH_SHORT).show()
                navigateToLogin()
            }
        }

        tvLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    private fun validateInput(
        firstName: String,
        lastName: String,
        email: String,
        password: String
    ): Boolean {
        if (firstName.isEmpty()) {
            showErrorToast("First Name harus diisi")
            return false
        }

        if (lastName.isEmpty()) {
            showErrorToast("Last Name harus diisi")
            return false
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            showErrorToast("Email tidak valid")
            return false
        }

        if (password.length < 6) {
            showErrorToast("Password minimal 6 karakter")
            return false
        }

        return true
    }

    private fun showErrorToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun navigateToLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}