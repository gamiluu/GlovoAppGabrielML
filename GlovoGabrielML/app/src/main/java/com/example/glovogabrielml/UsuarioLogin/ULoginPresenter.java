package com.example.glovogabrielml.UsuarioLogin;

import com.example.glovogabrielml.Beans.Usuario;
import com.example.glovogabrielml.RestauranteLogin.RLoginContract;

public class ULoginPresenter implements ULoginContract.Presenter, ULoginContract.Model.onULoginListener{
    //ATRIBUTOS
    private ULoginContract.View view;
    private ULoginContract.Model model;

    //CONSTRUCTORES
    public ULoginPresenter(ULoginContract.View view){
        this.view = view;
        model = new ULoginModel(this);
    }

    //MÉTODOS
    @Override
    public void login(Usuario usuario) {
        model.loginAPI(usuario, this);
    }
    @Override
    public void onFinished(ULoginData uLoginData) {
        view.successLogin(uLoginData);
    }
    @Override
    public void onFailure(String err) {
        view.failureLogin(err);
    }
}
