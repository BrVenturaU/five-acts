package com.example.fiveacts.presenters.imcPresenter

import com.example.fiveacts.views.imcView.IImcView
import kotlinx.android.synthetic.main.activity_imc.*

class ImcPresenter(val view: IImcView): IImcPresenter {
    override fun calculateImc(peso: Double, altura: Double) {
        val IMC: Double = calculate(peso, altura)
        if (IMC <= 16){
            this.imcResult(IMC.toString())
            this.imcRange("Bajo Peso: Delgadez Severa")
        }
        else if (IMC >16 && IMC<=16.9){
            this.imcResult(IMC.toString())
            this.imcRange("Bajo Peso: Delgadez Modera")
        }
        else if (IMC >17 && IMC<=18.49){
            this.imcResult(IMC.toString())
            this.imcRange("Bajo Peso: Delgadez Leve")
        }
        else if (IMC in 18.5..24.9){
            this.imcResult(IMC.toString())
            this.imcRange("Peso Normal")
        }
        else if (IMC >=25.0 && IMC<=29.99){
            this.imcResult(IMC.toString())
            this.imcRange("Sobrepeso: Preobeso")
        }
        else if (IMC >30.0 && IMC<=34.9){
            this.imcResult(IMC.toString())
            this.imcRange("Obsidad: Obsidad Leve")
        }
        else if (IMC >35.0 && IMC <=39.9){
            this.imcResult(IMC.toString())
            this.imcRange("Obsidad: Obsidad Media")
        }
        else if (IMC >= 40.0){
            this.imcResult(IMC.toString())
            this.imcRange("Obsidad: Obsidad Morbida")
        }
    }

    override fun imcResult(mensaje: String) {
        view.onImcResult(mensaje)
    }

    override fun imcRange(mensaje: String) {
        view.onImcRange(mensaje)
    }

    private fun calculate(peso: Double, altura: Double): Double{
        return  (peso / (altura * altura))
    }
}