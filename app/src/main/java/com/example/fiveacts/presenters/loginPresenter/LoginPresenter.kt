package com.example.fiveacts.presenters.loginPresenter

import androidx.core.text.isDigitsOnly
import com.example.fiveacts.interceptors.loginInterceptor.ILoginInterceptor
import com.example.fiveacts.interceptors.loginInterceptor.LoginInterceptor
import com.example.fiveacts.models.User
import com.example.fiveacts.views.loginView.ILoginView

class LoginPresenter(val view: ILoginView): ILoginPresenter {
    val interceptor: ILoginInterceptor = LoginInterceptor(this)
    override fun login(email: String, password: String) {
        if (email.isBlank() or email.isNullOrEmpty() or !email.contains("@"))
            loginErrorMessage("El email debe contener un correo valido.")
        else if (password.isBlank() or password.isNullOrEmpty() or password.isDigitsOnly())
            loginErrorMessage("La contraseña no puede quedar vacia.")
        else{
            val user = User(email, password)
            interceptor.login(user)
        }
    }

    override fun hasUserAccount() {
        interceptor.hasUserAccount()
    }

    override fun isUserAccount(state: Boolean) {
        view.isUserAccount(state)
    }

    override fun hasSession() {
        interceptor.hasSession()
    }

    override fun isAuth(state: Boolean) {
        view.isAuth(state)
    }

    override fun loginResultMessage(mensaje: String) {
        view.onLoginResultMessage(mensaje)
    }

    override fun loginErrorMessage(mensaje: String) {
        view.onLoginErrorMessage(mensaje)
    }


}