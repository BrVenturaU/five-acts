package com.example.fiveacts.interceptors.loginInterceptor

import com.example.fiveacts.models.User
import com.example.fiveacts.presenters.loginPresenter.ILoginPresenter
import com.example.fiveacts.utils.SharedApp

class LoginInterceptor(val presenter: ILoginPresenter): ILoginInterceptor {
    override fun login(user: User) {
        try {
            val email: String? = SharedApp.preferences.preferences.getString(SharedApp.preferences.SHARED_EMAIL, "")
            val password: String? = SharedApp.preferences.preferences.getString(email, "")
            if (!email.equals(user.email))
                presenter.loginErrorMessage("Correo electronico invalido. Por favor verifique.")
            else if(!password.equals(user.password))
                presenter.loginErrorMessage("Contraseña invalida. Por favor verifique.")
            else{
                SharedApp.preferences.preferences.edit().
                    putBoolean("isAuth", true).apply()
                presenter.loginResultMessage("Iniciando Sesión")
            }
        }catch (ex: Exception){
            presenter.loginErrorMessage("Ha ocurrido un error. No se ha podido iniciar sesión. Comuniquese con sistemas.")
        }
    }

    override fun hasUserAccount() {
        val email: String? = SharedApp.preferences.preferences.getString(SharedApp.preferences.SHARED_EMAIL, "")
        presenter.isUserAccount(!email.isNullOrEmpty())
    }

    override fun hasSession() {
        val isAuth: Boolean? = SharedApp.preferences.preferences.getBoolean("isAuth", false)
        presenter.isAuth(isAuth ?: false)
    }

}