package com.example.healthvault

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.healthvault.databinding.ActivityDataEntryBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class DataEntry : AppCompatActivity() {
    private val binding : ActivityDataEntryBinding by lazy {
        ActivityDataEntryBinding.inflate(layoutInflater)
    }
    private lateinit var firebaseRef : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        firebaseRef = FirebaseDatabase.getInstance().getReference("Details")


        binding.saveButton.setOnClickListener {

            saveData()


            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun saveData() {
        val name = binding.nameText.text.toString()
        val middleName = binding.middleText2.text.toString()
        val lastName = binding.lastText3.text.toString()
        val height = binding.heightNumber.text.toString()
        val weight = binding.weightNumber2.text.toString()

        val detailsId = firebaseRef.push().key!!
        val details = Details(detailsId, name, middleName, lastName, height, weight)

        firebaseRef.child(detailsId).setValue(details)
            .addOnCompleteListener() {
                Toast.makeText(this, "data Stored Successfully..!", Toast.LENGTH_SHORT).show()
            }

            .addOnFailureListener {
                Toast.makeText(this, "Error ${it.message}", Toast.LENGTH_SHORT).show()
            }
    }
}