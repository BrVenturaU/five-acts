package com.example.fiveacts.views.calculadoraView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import com.example.fiveacts.R
import kotlinx.android.synthetic.main.activity_calculadora.*

class CalculadoraActivity : AppCompatActivity(), View.OnClickListener {
    var num1 : Float? = null
    var num2 : Float? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        btnSuma.setOnClickListener(this)
        btnResta.setOnClickListener(this)
        btnmulti.setOnClickListener(this)
        btnDiv.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (TextUtils.isEmpty(editNumUno.text.toString())) {
            editNumUno.error = "Ingrese un número"
            editNumUno.requestFocus()
            return
        }else{
            num1 = editNumUno.text.toString().toFloat()
        }
        if (TextUtils.isEmpty(editNumDos.text.toString())) {
            editNumDos.error = "Ingrese un número"
            editNumDos.requestFocus()
            return
        }else{
            num2 = editNumDos.text.toString().toFloat()
        }

        when(v?.id){
            R.id.btnSuma -> {txtResultado.text = num1?.plus(num2!!).toString()}

            R.id.btnResta -> {txtResultado.text = num1?.minus(num2!!).toString()}

            R.id.btnmulti -> {txtResultado.text = num1?.times(num2!!).toString()}

            R.id.btnDiv -> {txtResultado.text = num1?.div(num2!!).toString()}
        }

    }
}