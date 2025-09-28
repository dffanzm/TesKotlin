package com.example.teskotlin

import android.content.Intent
import android.net.Uri
import android.view.View
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val buttonnext = findViewById<Button>(R.id.button_next)


        buttonnext.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        })
    }


}


