package com.example.groupproject_linkup

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.groupproject_linkup.databinding.RegisterActivityBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    // declaring variable to hold refrences
    private lateinit var binding: RegisterActivityBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        binding register activity using inflate
        binding = RegisterActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Using firebase authenticator
        firebaseAuth = FirebaseAuth.getInstance()

        // binding the input fields by clicking on btn
        binding.button.setOnClickListener {
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()
            val confirmPassword = binding.editTextConfirmpasswrod.text.toString()

            // adding the validation whether it is empty or not
            if (email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
                if (password == confirmPassword) {
                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener {
                            if (it.isSuccessful) {
                                val intent = Intent(this, LoginActivity::class.java)
                                startActivity(intent)
                            } else {
                                Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }

                } else {
                    Toast.makeText(
                        this,
                        "Password and Confirm password is not same",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(this, "Fields Required !!", Toast.LENGTH_SHORT).show()
            }
        }
        binding.redirectLoginPage.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}

