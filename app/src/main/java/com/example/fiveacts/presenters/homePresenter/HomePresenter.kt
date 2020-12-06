package com.example.fiveacts.presenters.homePresenter

import com.example.fiveacts.interceptors.homeInterceptor.HomeInterceptor
import com.example.fiveacts.interceptors.homeInterceptor.IHomeInterceptor
import com.example.fiveacts.views.homeView.IHomeView

class HomePresenter(val view: IHomeView): IHomePresenter {
    val interceptor: IHomeInterceptor = HomeInterceptor(this)
    override fun logout() {
        interceptor.logout()
    }

    override fun logoutResultMessage(mensaje: String) {
        view.onLogoutResultMessage(mensaje)
    }

    override fun logoutErrorMessage(mensaje: String) {
        view.onLogoutResultMessage(mensaje)
    }

}