package com.example.konekin

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.navigation.fragment.findNavController
import com.example.konekin.databinding.FragmentHomeBinding
import com.example.konekin.model.Data
import com.example.konekin.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val client = ApiClient.getInstance()
        val response = client.getAllUsers()

        response.enqueue(object : Callback<Data> {
            override fun onResponse(call: Call<Data>, response: Response<Data>) {
                val users = response.body()?.data ?: emptyList()

                // Initialize UserAdapter with click listener
                val adapter = UserAdapter(users) { user ->
                    val bundle = Bundle().apply {
                        putString("name", user.firstName)
                        putString("email", user.email)
                        putString("avatar", user.avatar)
                    }
                    findNavController().navigate(R.id.action_homeFragment_to_profileFragment, bundle)
                }
                binding.recyclerView.adapter = adapter
                binding.recyclerView.layoutManager = LinearLayoutManager(context)
            }

            override fun onFailure(call: Call<Data>, t: Throwable) {
                Toast.makeText(context, "Connection error", Toast.LENGTH_LONG).show()
            }
        })
    }
}
