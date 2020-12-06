package com.example.fiveacts.interceptors.homeInterceptor

import com.example.fiveacts.presenters.homePresenter.IHomePresenter
import com.example.fiveacts.utils.SharedApp
import java.lang.Exception

class HomeInterceptor(val presenter: IHomePresenter): IHomeInterceptor {
    override fun logout() {
        try {
            SharedApp.preferences.preferences.edit().
            putBoolean("isAuth", false).apply()
            presenter.logoutResultMessage("Su sesión se ha cerrado exitosamente.")
        }catch (ex: Exception){
            presenter.logoutErrorMessage("Ha ocurrido un error. No se ha podido iniciar sesión. Comuniquese con sistemas.")
        }
    }

}