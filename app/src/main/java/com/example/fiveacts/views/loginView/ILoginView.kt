package com.example.fiveacts.views.loginView

interface ILoginView {
    fun isAuth(state: Boolean)
    fun onLoginResultMessage(mensaje: String)
    fun onLoginErrorMessage(mensaje: String)
    fun isUserAccount(state: Boolean)
}