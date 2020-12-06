package com.example.fiveacts.views.registryView

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.fiveacts.R
import com.example.fiveacts.presenters.registryPresenter.IRegistryPresenter
import com.example.fiveacts.presenters.registryPresenter.RegistryPresenter
import com.example.fiveacts.views.loginView.LoginActivity

class RegisterActivity : AppCompatActivity(), IRegistryView, View.OnClickListener {
    var presenter: IRegistryPresenter? = null
    var etEmail: EditText? = null
    var etPassword: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val btnUnirme: Button = findViewById(R.id.btnUnirme)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        presenter = RegistryPresenter(this)

        btnUnirme.setOnClickListener(this)
    }

    override fun onCreateUserResultMessage(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
        val intent: Intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onCreateUserErrorMessage(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.btnUnirme -> {
                presenter?.createUser(etEmail?.text.toString(), etPassword?.text.toString())
            }
        }
    }
}