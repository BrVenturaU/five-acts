package com.example.fiveacts.views.imcView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fiveacts.R
import com.example.fiveacts.presenters.imcPresenter.IImcPresenter
import com.example.fiveacts.presenters.imcPresenter.ImcPresenter
import kotlinx.android.synthetic.main.activity_imc.*

class ImcActivity : AppCompatActivity(), IImcView {
    var presenter: IImcPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)
        presenter = ImcPresenter(this)
        //BONTON : CALCULAR
        btnCalcular.setOnClickListener() {
            //  DEFINCION DE VARIABLES
            var Peso : Double = etPeso.text.toString().toDouble()
            var Altura : Double = etAltura.text.toString().toDouble()
            presenter?.calculateImc(Peso, Altura)
        }

        //LIMPIAR CAMPOS --- BOTON : VOLVER A INTERNTAR
        btnIntento.setOnClickListener(){
            etPeso.text.clear()
            etAltura.text.clear()
            tvResultado.text =""
            tvRango.text=""
        }
    }

    override fun onImcResult(mensaje: String) {
        tvResultado.text = mensaje
    }

    override fun onImcRange(mensaje: String) {
        tvRango.text = mensaje
    }
}