package com.example.healthvault

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.healthvault.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import java.nio.channels.InterruptedByTimeoutException

class SignUpActivity : AppCompatActivity() {
    private val binding : ActivitySignUpBinding by lazy {
        ActivitySignUpBinding.inflate(layoutInflater)
    }

    private lateinit var auth : FirebaseAuth



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Initialization FireBase Auth
        auth = FirebaseAuth.getInstance()

        binding.registerButton.setOnClickListener {
            // Get text from edit text field..!
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()
            val rePassword = binding.rePassword.text.toString()

            // Check if any field is blank..?
            if (email.isEmpty() || password.isEmpty() || rePassword.isEmpty())
            {
                Toast.makeText(this, "Please Fill all the Details..!", Toast.LENGTH_SHORT).show()
            }
            else if (password != rePassword)
            {
                Toast.makeText(this, "Password and Re-Password do not match..!", Toast.LENGTH_SHORT).show()
            }
            else if (password.length < 6)
            {
                Toast.makeText(this, "Password should be at least 6 charecters..!", Toast.LENGTH_SHORT).show()
            }
            else
            {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful){
                            Toast.makeText(this, "Registration Successfull..!", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this, LoginActivity::class.java))
                            finish()
                        }
                        else
                        {
                            Toast.makeText(this, "Regsitration Failed : ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
            }

        }

    }
}