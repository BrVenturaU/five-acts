package com.example.fiveacts.presenters.loginPresenter

import com.example.fiveacts.models.User

interface ILoginPresenter {
    fun login(email: String, password: String)
    fun loginResultMessage(mensaje: String)
    fun loginErrorMessage(mensaje: String)
    fun hasUserAccount()
    fun isUserAccount(state: Boolean)
    fun hasSession()
    fun isAuth(state: Boolean)
}