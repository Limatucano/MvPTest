package com.br.matheus.correa.mvptest.presenter

sealed interface LoginContract {

    interface View : BaseView<LoginPresenter>{
        fun displayErrorMessage(message: String)
        fun displaySucessMessage(message: String)
        fun startHomeScreen()
    }

    interface Presenter {
        fun checkLogin(username: String, password: String)
    }
}