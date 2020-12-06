package com.example.fiveacts.views.homeView

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.fiveacts.R
import com.example.fiveacts.presenters.homePresenter.HomePresenter
import com.example.fiveacts.presenters.homePresenter.IHomePresenter
import com.example.fiveacts.views.calculadoraDescuentoView.CalculadoraDescuentoActivity
import com.example.fiveacts.views.calculadoraView.CalculadoraActivity
import com.example.fiveacts.views.imcView.ImcActivity
import com.example.fiveacts.views.loginView.LoginActivity
import com.example.fiveacts.views.promedioView.PromedioNotasActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), View.OnClickListener, IHomeView {
    var presenter: IHomePresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        presenter = HomePresenter(this)

        btnCerrarSesion.setOnClickListener(this)
        btnCalculadora.setOnClickListener(this)
        btnPromedio.setOnClickListener(this)
        btnDescuento.setOnClickListener(this)
        btnImc.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        var intent: Intent? = null
        when(view?.id){
            R.id.btnCalculadora -> {
                intent = Intent(this, CalculadoraActivity::class.java)
                startActivity(intent)
            }

            R.id.btnPromedio -> {
                intent = Intent(this, PromedioNotasActivity::class.java)
                startActivity(intent)
            }

            R.id.btnDescuento -> {
                intent = Intent(this, CalculadoraDescuentoActivity::class.java)
                startActivity(intent)
            }

            R.id.btnImc -> {
                intent = Intent(this, ImcActivity::class.java)
                startActivity(intent)
            }

            R.id.btnCerrarSesion -> {
                presenter?.logout()
            }
        }
    }

    override fun onLogoutResultMessage(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
        val intent: Intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onLogoutErrorMessage(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }
}