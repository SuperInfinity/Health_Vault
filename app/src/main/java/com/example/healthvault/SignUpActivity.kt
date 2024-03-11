package com.example.healthvault

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.healthvault.databinding.ActivitySignUpBinding
import java.nio.channels.InterruptedByTimeoutException

class SignUpActivity : AppCompatActivity() {
    private val binding : ActivitySignUpBinding by lazy {
        ActivitySignUpBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.loginSButton.setOnClickListener {
        }
    //hello this file takes a l;ot to push..!
        //jajaja
    }
}