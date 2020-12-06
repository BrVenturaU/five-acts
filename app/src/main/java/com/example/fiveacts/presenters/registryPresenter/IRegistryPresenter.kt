package com.example.fiveacts.presenters.registryPresenter

interface IRegistryPresenter {
    fun createUser(email: String, password: String)
    fun createUserResultMessage(mensaje: String)
    fun createUserErrorMessage(mensaje: String)
}