package com.example.konekin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.konekin.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private val binding by lazy{
        FragmentProfileBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Retrieve data from arguments
        val name = arguments?.getString("name") ?: "Unknown"
        val email = arguments?.getString("email") ?: "Unknown"
        val avatar = arguments?.getString("avatar")

        // Populate views
        binding.tvName.text = name
        binding.tvEmail.text = email
        Glide.with(this)
            .load(avatar)
            .into(binding.imgAvatar)

        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}