package com.example.fiveacts.interceptors.registryInterceptor

import com.example.fiveacts.interceptors.registryInterceptor.IRegistryInterceptor
import com.example.fiveacts.models.User
import com.example.fiveacts.presenters.registryPresenter.IRegistryPresenter
import com.example.fiveacts.utils.SharedApp

class RegistryInterceptor(val presenter: IRegistryPresenter):
    IRegistryInterceptor {
    override fun createUser(user: User) {
        try{
            SharedApp.preferences.preferences.edit().
                putString(SharedApp.preferences.SHARED_EMAIL, user.email).apply()
            SharedApp.preferences.preferences.edit()
                .putString(user.email, user.password).apply()
            presenter.createUserResultMessage("Se ha creado su usuario.")
        }catch (ex: Exception){
            presenter.createUserErrorMessage("Ha ocurrido un error. No se ha podido crear su usuario. Comuniquese con sistemas.")
        }
    }
}