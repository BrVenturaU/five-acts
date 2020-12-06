package com.example.fiveacts.views.promedioView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fiveacts.R
import kotlinx.android.synthetic.main.activity_promedio_notas.*

class PromedioNotasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_promedio_notas)
        promedio()

        limpieza.setOnClickListener { txt_resultado.text = "El genio se hace con un 1% de talento, y un 99% de trabajo.  Albert Einstein" }
    }

    fun promedio(){

        calculo.setOnClickListener {
            var valoruno: Double  = (nota1.text.toString()).toDouble()
            var valordos: Double   = (nota2.text.toString()).toDouble()
            var  valortres: Double = (nota3.text.toString()).toDouble()
            var resultado : String = ((valoruno + valordos + valortres)/ 3).toString()
            txt_resultado.text = (resultado)
        }

    }
}