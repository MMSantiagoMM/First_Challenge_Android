package com.example.imdb2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    lateinit var name:TextInputEditText
    lateinit var password:TextInputEditText
    lateinit var btn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(1000)
        installSplashScreen()
        setContentView(R.layout.activity_main)

        name = findViewById<TextInputEditText>(R.id.input_user)
        password = findViewById<TextInputEditText>(R.id.input_password)
        btn = findViewById<Button>(R.id.login)

        name.addTextChangedListener(textWatcher)
        password.addTextChangedListener(textWatcher)

    }
   private val textWatcher = object : TextWatcher{
       override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

       }

       override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
           val text1 = name.text.toString().trim()
           val text2 = password.text.toString().trim()
           btn.isEnabled = text1.length > 3 && text2.length > 3
       }

       override fun afterTextChanged(p0: Editable?) {

       }

   }
}