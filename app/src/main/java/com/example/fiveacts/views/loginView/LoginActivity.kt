package com.example.fiveacts.views.loginView

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.fiveacts.R
import com.example.fiveacts.presenters.loginPresenter.ILoginPresenter
import com.example.fiveacts.presenters.loginPresenter.LoginPresenter
import com.example.fiveacts.utils.SharedApp
import com.example.fiveacts.views.homeView.HomeActivity
import com.example.fiveacts.views.registryView.RegisterActivity

class LoginActivity : AppCompatActivity(), View.OnClickListener, ILoginView {
    var etEmail: EditText? = null
    var etPassword: EditText? = null
    var btnUnirme: Button? = null
    var presenter: ILoginPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter = LoginPresenter(this)
        presenter?.hasSession()

        val btnIniciar: Button = findViewById(R.id.btnIniciar)
        btnUnirme = findViewById(R.id.btnUnirme)
        presenter?.hasUserAccount()
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)

        btnIniciar.setOnClickListener(this)
        btnUnirme?.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btnIniciar -> {
                presenter?.login(etEmail?.text.toString(), etPassword?.text.toString())
            }
            R.id.btnUnirme -> {
                val intent: Intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
                finish()
            }
            else -> {

            }
        }
    }

    override fun isAuth(state: Boolean) {
        if(state){
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onLoginResultMessage(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
        val intent: Intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onLoginErrorMessage(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }

    override fun isUserAccount(state: Boolean) {
        if(state)
            btnUnirme?.visibility = View.GONE
    }
}