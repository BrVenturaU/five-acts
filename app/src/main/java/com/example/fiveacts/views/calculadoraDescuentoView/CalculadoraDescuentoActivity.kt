package com.example.fiveacts.views.calculadoraDescuentoView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.fiveacts.R

class CalculadoraDescuentoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora_descuento)

        val precioP=findViewById<EditText>(R.id.txtProducto)
        val descuento=findViewById<EditText>(R.id.txtPorcentaje)
        val calcular=findViewById<Button>(R.id.btnCalcular)
        var txtTotal=findViewById<TextView>(R.id.txtTotal)
        var txt=findViewById<TextView>(R.id.textView3)
        var imagen=findViewById<ImageView>(R.id.imageView4)

        calcular.setOnClickListener(android.view.View.OnClickListener {

            val precioProducto: Double = precioP.text.toString().toDouble()
            val porcentajeDescuento: Double = descuento.text.toString().toDouble()/100
            val descuentoProducto: Double =  precioProducto * porcentajeDescuento

            val totalDescuento: Double = calcularPrecioFinal(precioProducto, descuentoProducto)

            txtTotal.text = totalDescuento.toString()

            txtTotal.setVisibility(View.VISIBLE)
            txt.setVisibility(View.VISIBLE)
            imagen.setVisibility(View.VISIBLE)

        })
    }

    fun calcularPrecioFinal(precio: Double, descuento: Double): Double{
        return precio - descuento
    }

}