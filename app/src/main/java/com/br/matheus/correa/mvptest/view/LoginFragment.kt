package com.br.matheus.correa.mvptest.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.findNavController
import com.br.matheus.correa.mvptest.databinding.FragmentLoginBinding
import com.br.matheus.correa.mvptest.presenter.LoginContract
import com.br.matheus.correa.mvptest.presenter.LoginPresenter


class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate), LoginContract.View {

    override lateinit var presenter: LoginPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = LoginPresenter(this)
        binding.buttonLogin.setOnClickListener {
            presenter.checkLogin(
                username = binding.etLogin.text.toString(),
                password = binding.etPassword.text.toString()
            )
        }
    }

    override fun displayErrorMessage(message: String) {
        toastMakeText(message)
    }

    override fun displaySucessMessage(message: String) {
        toastMakeText(message)
    }

    override fun startHomeScreen() {
        LoginFragmentDirections.actionLoginFragmentToHomeFragment().let {
            requireView().findNavController().navigate(it)
        }
    }

    private fun toastMakeText(message: String){
        Toast.makeText(requireContext(),message,Toast.LENGTH_SHORT).show()
    }
}