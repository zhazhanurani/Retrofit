package com.example.konekin

// UserAdapter.kt
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.konekin.databinding.ItemUserBinding
import com.example.konekin.model.Users


class UserAdapter(
    private val userList: List<Users>,
    private val onUserClick: (Users) -> Unit // Callback function
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    inner class UserViewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        with(holder.binding) {
            tvName.text = user.firstName
            tvEmail.text = user.email
            Glide.with(imgAvatar.context)
                .load(user.avatar)
                .into(imgAvatar)

            // Set click listener for the item
            root.setOnClickListener {
                onUserClick(user) // Trigger callback
            }
        }

    }

    override fun getItemCount() = userList.size
}