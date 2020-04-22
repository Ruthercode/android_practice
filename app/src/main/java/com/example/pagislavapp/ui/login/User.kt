package com.example.pagislavapp.ui.login

class User(var username: String, pass: String, var url: String) {
    var password: Int = pass.hashCode()

}

