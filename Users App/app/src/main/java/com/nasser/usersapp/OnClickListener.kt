package com.nasser.usersapp

import com.nasser.usersapp.classes.User

interface OnClickListener {
    fun onClick(user: User, position: Int)
}