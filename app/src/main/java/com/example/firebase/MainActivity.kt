package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity() : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    private lateinit var inputEmail: EditText
    private lateinit var inputPassword: EditText
    private lateinit var registrationButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputEmail = findViewById(R.id.Email)
        inputPassword = findViewById(R.id.Password)
        registrationButton = findViewById(R.id.Registration)

        mAuth = FirebaseAuth.getInstance();

        registrationButton.setOnClickListener {
            val Email = inputEmail.text.toString()
            val Password = inputPassword.text.toString()


            if (Email.isEmpty() || Password.isEmpty()) {
                Toast.makeText(this, "არ გვაქ მხიარულად საქმე", Toast.LENGTH_SHORT).show()
            } else {
                mAuth.createUserWithEmailAndPassword(Email, Password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "მხიარულადაა საქმე", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, "არ გვაქ მხიარულად საქმე", Toast.LENGTH_SHORT).show()
                        }

                    }
            }
        }
    }
}