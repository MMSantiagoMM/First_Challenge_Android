package com.example.imdb2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.imdb2.databinding.FragmentRegisterBinding


class Register : Fragment(R.layout.fragment_register) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var binding = FragmentRegisterBinding.bind(view)
        binding.arrow.setOnClickListener {
            findNavController().navigate(R.id.action_register2_to_login2)
        }
    }




    }
