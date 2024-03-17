package com.example.groupproject_linkup

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.groupproject_linkup.databinding.LoginActivityBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: LoginActivityBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = LoginActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize firebaseAuth
        firebaseAuth = FirebaseAuth.getInstance()

        binding.redirectRegisterPage.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

            binding.mainRedirectbtn.setOnClickListener {
                val email = binding.editTextEmail.text.toString()
                val password = binding.editTextPassword.text.toString()

                // adding the validation whether it is empty or not
                if (email.isNotEmpty() && password.isNotEmpty()) {

                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->
                            // adding some validation on email and password
                            if (task.isSuccessful) {
                                val intent = Intent(this, MainActivity::class.java)
                                startActivity(intent)

                            } else {
                                val msg = when {
                                    task.exception is FirebaseAuthUserCollisionException -> {
                                        val intent = Intent(this, MainActivity::class.java)
                                        startActivity(intent)
                                    }

                                    else -> {
                                        "Sign up failed: ${task.exception?.message}"
                                    }
                                }
                            }
                        }
                } else {
                    Toast.makeText(this, "All Fields Required !!", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
