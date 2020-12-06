package com.example.fiveacts.presenters.imcPresenter

interface IImcPresenter {
    fun calculateImc(peso: Double, altura: Double)
    fun imcResult(mensaje: String)
    fun imcRange(mensaje: String)
}