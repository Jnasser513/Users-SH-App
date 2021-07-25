package com.nasser.usersapp

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.nasser.usersapp.classes.User
import com.nasser.usersapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var userAdapter: UserAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val preference = getPreferences(Context.MODE_PRIVATE)

        val isFirstTime = preference.getBoolean(getString(R.string.sp_first_time), true)
        Log.i("SP", "${getString(R.string.sp_first_time)} = $isFirstTime")

        if(isFirstTime) {
            MaterialAlertDialogBuilder(this)
                .setTitle(R.string.dialog_tittle)
                .setPositiveButton(R.string.dialog_confirm, { dialog, which ->
                    preference.edit().putBoolean(getString(R.string.sp_first_time), false).commit()
                })
                .setNegativeButton("Cancelar", null)
                .show()
        }

        userAdapter = UserAdapter(getUsers(), this)
        linearLayoutManager = LinearLayoutManager(this)

        binding.usersRecyclerview.apply {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            adapter = userAdapter
        }
    }

    private fun getUsers(): MutableList<User> {
        val users = mutableListOf<User>()

        val jnasser = User(1, "Jose", "Nasser", "https://i.pinimg.com/736x/15/94/0c/15940cd9f607fec3675ff5161df83a5e.jpg")
        val adriana = User(2, "Adriana", "Reyes", "https://i.pinimg.com/236x/08/6b/df/086bdf679f8cfbfb37c2b871c0993b19.jpg")
        val andre = User(3, "Jose", "Fernandez", "https://previews.123rf.com/images/grgroup/grgroup1611/grgroup161108920/65491767-icono-de-dibujos-animados-chico-ni%C3%B1ez-ni%C3%B1o-peque%C3%B1o-persona-personas-y-el-tema-dise%C3%B1o-aislado-ilustra.jpg")
        val marcela = User(4, "Marcela", "Nasser", "https://previews.123rf.com/images/grgroup/grgroup1611/grgroup161108926/65491774-icono-de-dibujos-animados-chica-ni%C3%B1ez-ni%C3%B1o-peque%C3%B1o-persona-personas-y-el-tema-dise%C3%B1o-aislado-ilustra.jpg")

        users.add(jnasser)
        users.add(adriana)
        users.add(andre)
        users.add(marcela)
        users.add(jnasser)
        users.add(adriana)
        users.add(andre)
        users.add(marcela)
        users.add(jnasser)
        users.add(adriana)
        users.add(andre)
        users.add(marcela)
        users.add(jnasser)
        users.add(adriana)
        users.add(andre)
        users.add(marcela)

        return users
    }

    override fun onClick(user: User, position: Int) {
        Toast.makeText(this, "$position: ${user.getFullName()}" , Toast.LENGTH_SHORT).show()
    }
}