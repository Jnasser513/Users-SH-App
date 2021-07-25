package com.nasser.usersapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.nasser.usersapp.classes.User
import com.nasser.usersapp.databinding.ItemUserAltBinding
import com.nasser.usersapp.databinding.ItemUserBinding

class UserAdapter(private val users: List<User>, private val listener: OnClickListener):
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private lateinit var context: Context

    //Metodo para crear la vista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        val view = LayoutInflater.from(context).inflate(R.layout.item_user_alt, parent, false)

        return ViewHolder(view)
    }

    //Metodo para rellenar la informacion
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users.get(position)

        with(holder) {
            setListener(user, position + 1)
            binding.orderTextView.text = (position + 1).toString()
            binding.nameTextView.text = user.getFullName()
            Glide.with(context)
                .load(user.url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .circleCrop()
                .into(binding.cardImgPhoto)
        }
    }

    //Indica la cantidad de elementos del adapter
    override fun getItemCount(): Int = users.size

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = ItemUserAltBinding.bind(view)

        fun setListener(user: User, position: Int){
            binding.root.setOnClickListener {
                listener.onClick(user, position)
            }
        }
    }

}