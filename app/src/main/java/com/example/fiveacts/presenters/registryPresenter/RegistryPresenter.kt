package com.example.fiveacts.presenters.registryPresenter

import androidx.core.text.isDigitsOnly
import com.example.fiveacts.interceptors.registryInterceptor.IRegistryInterceptor
import com.example.fiveacts.interceptors.registryInterceptor.RegistryInterceptor
import com.example.fiveacts.models.User
import com.example.fiveacts.views.registryView.IRegistryView

class RegistryPresenter (val view: IRegistryView): IRegistryPresenter {

    val interceptor: IRegistryInterceptor = RegistryInterceptor(this)

    override fun createUser(email: String, password: String) {
        if (email.isBlank() or email.isNullOrEmpty() or !email.contains("@"))
            createUserErrorMessage("El email debe contener un correo valido.")
        else if (password.isBlank() or password.isNullOrEmpty() or password.isDigitsOnly())
            createUserErrorMessage("La contraseña no puede quedar vacia.")
        else{
            val user = User(email, password)
            interceptor.createUser(user)
        }
    }

    override fun createUserResultMessage(mensaje: String) {
        view.onCreateUserResultMessage(mensaje)
    }

    override fun createUserErrorMessage(mensaje: String) {
        view.onCreateUserErrorMessage(mensaje)
    }
}