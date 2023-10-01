package com.example.imdb2

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.imdb2.databinding.FragmentLoginBinding
import com.google.android.material.textfield.TextInputEditText


class LoginFragment : Fragment() {
    lateinit var name: TextInputEditText
    lateinit var password: TextInputEditText
    lateinit var btn: Button
    lateinit var register: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentLoginBinding.bind(view)

        name = binding.inputUser
        password = binding.inputPassword
        btn = binding.login
        register = binding.register

        name.addTextChangedListener(textWatcher)
        password.addTextChangedListener(textWatcher)

        register.setOnClickListener {
            findNavController().navigate(R.id.action_login2_to_register2)
        }
        btn.setOnClickListener {
            activity?.finish()
            findNavController().navigate(R.id.action_login2_to_mainActivity2)
        }


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