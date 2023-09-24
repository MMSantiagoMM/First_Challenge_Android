package com.example.imdb2

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.imdb2.databinding.FragmentLoginBinding
import com.google.android.material.textfield.TextInputEditText


class Login : Fragment() {
    lateinit var name: TextInputEditText
    lateinit var password: TextInputEditText
    lateinit var btn: Button
    // TODO: Rename and change types of parameters


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentLoginBinding.bind(view)

        name = binding.inputUser
        password = binding.inputPassword
        btn = binding.login

        name.addTextChangedListener(textWatcher)
        password.addTextChangedListener(textWatcher)
    }

    private val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            val text1 = name.text.toString().trim()
            val text2 = password.text.toString().trim()
            btn.isEnabled = text1.length > 3 && text2.length > 3
        }
        override fun afterTextChanged(p0: Editable?) {}
    }
}