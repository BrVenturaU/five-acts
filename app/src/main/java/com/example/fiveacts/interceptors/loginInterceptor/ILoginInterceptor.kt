package com.example.fiveacts.interceptors.loginInterceptor

import com.example.fiveacts.models.User

interface ILoginInterceptor {
    fun login(user: User)
    fun hasUserAccount()
    fun hasSession()
}