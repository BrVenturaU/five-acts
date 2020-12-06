package com.example.fiveacts.presenters.homePresenter

interface IHomePresenter {
    fun logout()
    fun logoutResultMessage(mensaje: String)
    fun logoutErrorMessage(mensaje: String)
}