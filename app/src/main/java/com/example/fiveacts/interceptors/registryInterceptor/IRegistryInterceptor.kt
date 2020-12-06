package com.example.fiveacts.interceptors.registryInterceptor

import com.example.fiveacts.models.User

interface IRegistryInterceptor {
    fun createUser(user: User)
}