package com.br.matheus.correa.mvptest.presenter

import com.br.matheus.correa.mvptest.model.AuthUtils

class LoginPresenter(private val view: LoginContract.View) : LoginContract.Presenter {

    override fun checkLogin(username: String, password: String) {
        if (username.isEmpty() && password.isEmpty()) {
            view.displayErrorMessage("Necessário todos campos!")
        }

        if (AuthUtils.USERNAME == username && AuthUtils.PASSWORD == password) {
            view.displaySucessMessage("Login efetuado com sucesso")
            view.startHomeScreen()
        } else {
            view.displayErrorMessage("Usuário ou senha inválido")
        }

    }
}